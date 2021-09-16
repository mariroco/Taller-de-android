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
    private var type : Boolean = true
    lateinit var ArticleList: MutableList<Article>
    var favCounter : Int =0
    var counter : Int =0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)
        initView()
        loadArticles()
        //setArticle()
        loadViewType(type)
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
        type = intent.getBooleanExtra("type",TRUE)

        //When we click on imgMain, we can see the image's details
        imgMain.setOnClickListener {  }

        //Click to go to last article in carrousel
        imgPrevious.setOnClickListener {  }

        //Click to go to next article in carrousel
        imgNext.setOnClickListener {  }

    }

    private fun loadViewType(type: Boolean) {
        if(type){//If the user is a Reader
            setHeart(FALSE)
            imgAdd.visibility = GONE
            txtUsername.setText("Reader")
            txtUserType.setText(getString(R.string.txt_userReader))
            imgUser.setImageResource(R.drawable.ic_reader)
            ArticleList.forEach{ article ->
                if(article.Status){
                    favCounter++
                }
            }
            txtNum.setText(getString(R.string.txt_heartedArticles,favCounter.toString()))
            //Click to heart
            imgFavDel.setOnClickListener {
                if(ArticleList[counter].Status){
                    ArticleList[counter].Status=FALSE
                    setHeart(FALSE)
                }else{
                    ArticleList[counter].Status=TRUE
                    setHeart(TRUE)
                }
            }
        }else{//If the user is a Writer
            imgFavDel.setImageResource(R.drawable.ic_delete)
            txtUsername.setText("Writer")
            txtUserType.setText(getString(R.string.txt_userWriter)).toString()
            txtNum.setText(getString(R.string.txt_writtenArticles,(ArticleList.size).toString()))
            imgUser.setImageResource(R.drawable.ic_writer)
            //Click to delete
            imgFavDel.setOnClickListener {
                ArticleList.removeAt(counter)
            }
            imgAdd.setOnClickListener{
                startActivity(Intent(this, ArticleGallery::class.java).apply {
                    putExtra("type",type)
                })
            }
        }
    }

    private fun loadArticles(){
        ArticleList = getSharedPref()

        if(ArticleList.size<1){
            txtTitle.setText(getString(R.string.txt_nothingHere))
            imgMain.visibility = INVISIBLE
            imgNext.visibility = INVISIBLE
            imgPrevious.visibility=INVISIBLE
            imgFavDel.visibility = INVISIBLE
            imgAdd.visibility = VISIBLE
        }else{
            txtTitle.setText(ArticleList[counter].Title)
            imgMain.visibility = VISIBLE
            imgNext.visibility = VISIBLE
            imgPrevious.visibility=VISIBLE
            imgFavDel.visibility = VISIBLE
            imgAdd.visibility = INVISIBLE
        }
    }

    private fun setArticle(){
        var article = ArticleList[counter]
        txtTitle.text = article.Title
        imgMain.setImageResource(article.Image)
        setHeart(article.Status)
    }

    private fun setHeart(status:Boolean){
        if (status){
            imgFavDel.setImageResource(R.drawable.ic_heart)
        }else{
            imgFavDel.setImageResource(R.drawable.ic_heart_empty)
        }
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

}