package com.mariroco.appexamen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.preference.PreferenceManager
import android.view.View.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.Boolean.FALSE
import java.lang.Boolean.TRUE


class UserProfile : AppCompatActivity() {
    private lateinit var imgUser : ImageView
    private lateinit var txtUsername : TextView
    private lateinit var txtUserType : TextView
    private lateinit var txtNum : TextView
    private lateinit var imgMain : ImageView
    private lateinit var txtTitle : TextView
    private lateinit var imgNext :ImageView
    private lateinit var imgPrevious :ImageView
    private lateinit var imgFavDel : ImageView
    private lateinit var imgAdd : ImageView
    private var utype : Boolean = true
    lateinit var ArticleList: MutableList<Article>
    var favCounter : Int =0
    var counter : Int =0

    var t : Int=0

    override fun onResume() {
        super.onResume()
        var oldsize =ArticleList.size
        ArticleList = getSharedPref()
        if(ArticleList.size>=1 && ArticleList.size>oldsize){
            counter=ArticleList.size-1
            setArticle()
            imgFavDel.visibility = VISIBLE
        }
        loadViewType()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)
        ArticleList = getSharedPref()
        initView()
        loadArticles()
        loadViewType()
    }

    private fun  initView(){
        imgUser = findViewById(R.id.imgUser)
        txtUsername = findViewById(R.id.txtUsername)
        txtUserType = findViewById(R.id.txtUserType)
        txtNum = findViewById(R.id.txtNum)
        imgMain = findViewById(R.id.imgMain)
        txtTitle = findViewById(R.id.txtTitle)
        imgPrevious = findViewById(R.id.imgAnterior)
        imgNext = findViewById(R.id.imgSiguiente)
        imgFavDel = findViewById(R.id.imgFavDel)
        imgAdd = findViewById(R.id.imgAdd)
        utype = intent.getBooleanExtra("type",TRUE)

        //When we click on imgMain, we can see the image's details
        imgMain.setOnClickListener {
            startActivity(Intent(this, ArticleGallery::class.java).apply {
                putExtra("usertype",utype)
                if(ArticleList.size>=1 && counter>=0){
                    putExtra("currentArticle",ArticleList[counter])
                    putExtra("currentArticleId",counter)
                }

            })
        }

        //Click to go to last article in carrousel
        imgPrevious.setOnClickListener {  }

        //Click to go to next article in carrousel
        imgNext.setOnClickListener {  }

    }

    private fun updateFavCounter(){
        favCounter=0
        ArticleList.forEach{ article ->
            if(article.Status){ favCounter++ }
        }
        txtNum.setText(getString(R.string.txt_heartedArticles,favCounter.toString()))
    }

    private fun loadViewType() {
        ArticleList = getSharedPref()
        txtUsername.setText(AppExamen.usersPref.getReader())
        txtUserType.setText(getString(R.string.txt_userReader))

        imgUser.setImageResource(R.drawable.ic_reader)
        imgAdd.visibility = GONE
        if(utype){//If the user is a Reader
            if(ArticleList.size<=1){
                txtTitle.setText(getString(R.string.txt_nothingHere))
                imgFavDel.visibility = INVISIBLE
                if(ArticleList.size==1){
                    setArticle()
                    imgFavDel.visibility= VISIBLE}
                imgNext.visibility= INVISIBLE
                imgPrevious.visibility = INVISIBLE

            }else{
                setArticle()
            }
            imgNext.setOnClickListener {
                counter++
                setImgCounter()
            }
            imgPrevious.setOnClickListener {
                counter--
                setImgCounter()
            }
            imgFavDel.setOnClickListener {
                if(ArticleList[counter].Status){
                    setHeart(FALSE)
                }else{
                    setHeart(TRUE)
                }
            }

        }else{//If the user is a Writer
            imgFavDel.setImageResource(R.drawable.ic_delete)
            txtUsername.setText(AppExamen.usersPref.getWriter())
            txtUserType.setText(getString(R.string.txt_userWriter)).toString()
            txtNum.setText(getString(R.string.txt_writtenArticles,(ArticleList.size).toString()))
            imgUser.setImageResource(R.drawable.ic_writer)
            imgAdd.visibility= INVISIBLE
            //Click to delete
            imgFavDel.setOnClickListener {
                ArticleList.removeAt(counter)
                saveSharedPref(ArticleList)
                counter=0
                loadViewType()
                loadArticles()
            }
            imgAdd.setOnClickListener{
                //Activity with new article form
                startActivity(Intent(this, ArticleGallery::class.java).apply {
                    putExtra("usertype",utype)
                    if(ArticleList.size>=1 && counter>=1){
                        putExtra("currentArticle",ArticleList[counter])
                        putExtra("currentArticleId",counter)
                    }

                })
            }
            imgNext.setOnClickListener {
                counter++
                setImgCounter()
            }
            imgPrevious.setOnClickListener {
                counter--
                setImgCounter()
            }
        }
    }

    private fun loadArticles(){
        ArticleList = getSharedPref()
        if(ArticleList.size<1){
            txtTitle.setText(getString(R.string.txt_nothingHere))
            imgMain.visibility = INVISIBLE
            if(utype && ArticleList.size==1){
                imgNext.visibility = INVISIBLE
                imgPrevious.visibility=INVISIBLE
            }else{
                imgNext.visibility = INVISIBLE
                imgPrevious.visibility=INVISIBLE
            }
            imgFavDel.visibility = INVISIBLE
            imgAdd.visibility = VISIBLE
        }else{
            txtTitle.setText(ArticleList[counter].Title)
            imgMain.setImageResource(ArticleList[counter].Image)
            imgMain.visibility = VISIBLE
            imgNext.visibility = VISIBLE
            imgPrevious.visibility=VISIBLE
            imgFavDel.visibility = VISIBLE
            imgAdd.visibility = INVISIBLE
        }
    }


    fun setArticle(){
        var article = ArticleList[counter]
        txtTitle.text = article.Title
        imgMain.setImageResource(article.Image)
        imgMain.visibility = VISIBLE
        imgNext.visibility = VISIBLE
        imgPrevious.visibility=VISIBLE
        imgAdd.visibility = INVISIBLE
        if(utype){setHeart(article.Status)
        }
    }

    private fun setHeart(status:Boolean){
        if (status){
            imgFavDel.setImageResource(R.drawable.ic_heart)
            ArticleList[counter].Status= TRUE
        }else{
            imgFavDel.setImageResource(R.drawable.ic_heart_empty)
            ArticleList[counter].Status= FALSE
        }
        saveSharedPref(ArticleList)
        updateFavCounter()
    }

    fun saveSharedPref(articles: List<Article>){
        val prefEditor = PreferenceManager.getDefaultSharedPreferences(this).edit()
        val jsonString = Gson().toJson(articles)
        prefEditor.putString("images",jsonString).apply()
    }

    private fun getSharedPref(): MutableList<Article> {
        val gson = Gson()
        val myType = object : TypeToken<List<Article>>() {}.type

        val preferences = PreferenceManager.getDefaultSharedPreferences(this)
        val jsonString = preferences.getString("images", null)
        return if(jsonString!=null){
            gson.fromJson(jsonString, myType)
        }else{
            mutableListOf()
        }
    }

    fun setImgCounter(){
        ArticleList = getSharedPref()
        if(utype){
            when(counter){
                -1 ->counter = ArticleList.size-1
                ArticleList.size -> counter=0
            }
        }else {
            when (counter) {
                -2 -> {
                    counter = ArticleList.size - 1
                    imgMain.visibility = VISIBLE
                    imgAdd.visibility = INVISIBLE
                    imgFavDel.visibility = VISIBLE
                }
                -1 -> {
                    imgMain.visibility = INVISIBLE
                    imgAdd.visibility = VISIBLE
                    imgFavDel.visibility = INVISIBLE
                    txtTitle.setText(getString(R.string.txt_addArticle))
                }
                0 -> imgFavDel.visibility = VISIBLE


                ArticleList.size -> {
                    counter = -1
                    imgMain.visibility = INVISIBLE
                    imgAdd.visibility = VISIBLE
                    imgFavDel.visibility = INVISIBLE
                    txtTitle.setText(getString(R.string.txt_addArticle))
                }
            }
        }
        if(counter!=-1){
        setArticle()}
    }

}