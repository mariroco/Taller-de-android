package com.mariroco.appexamen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.preference.PreferenceManager
import android.view.View.GONE
import android.view.View.VISIBLE
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
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
    private var type : Boolean = true
    lateinit var ArticleList: MutableList<Article>
    var counter : Int =0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)
        initView()
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
            imgFavDel.setImageResource(R.drawable.ic_heart_empty)
            txtUserType.text = (R.string.txt_userReader).toString()

            //Click to heart
            imgFavDel.setOnClickListener {  }

        }else{//If the user is a Writer
            imgFavDel.setImageResource(R.drawable.ic_delete)
            txtUserType.text = (R.string.txt_userWriter).toString()

            //Click to delete
            imgFavDel.setOnClickListener {
                ArticleList.removeAt(counter)
            }

        }
    }

    private fun loadArticles(){
        ArticleList = getSharedPref()

        if(ArticleList.size>1){
            txtTitle.text=(R.string.txt_nothingHere.toString())
            imgMain.visibility = GONE
            imgNext.visibility = GONE
            imgPrevious.visibility=GONE
            imgFavDel.visibility = GONE
        }else{
            txtTitle.text=(R.string.txt_nothingHere.toString())
            imgMain.visibility = VISIBLE
            imgNext.visibility = VISIBLE
            imgPrevious.visibility=VISIBLE
            imgFavDel.visibility = VISIBLE
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