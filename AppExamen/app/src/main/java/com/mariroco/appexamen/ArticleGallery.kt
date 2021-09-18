package com.mariroco.appexamen

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.ImageView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.Boolean.*

class ArticleGallery : AppCompatActivity() {
    private lateinit var imgMain : ImageView
    private lateinit var imgAnterior : ImageView
    private lateinit var imgSiquiente : ImageView
    private lateinit var containerFrag : FrameLayout
    private lateinit var edtxtTitle : EditText
    private lateinit var edtxtContent : EditText
    private lateinit var imgFav : ImageView
    private lateinit var imageOptions : List<Int>
    private var article: Article? = null
    private var utype : Boolean = FALSE
    private var counter : Int = 0
    private var currentArticleId : Int? = null
    lateinit var ArticleList: MutableList<Article>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_gallery)
        initView()

    }

    fun setUserView(){
        if(utype){
            imgMain.setImageResource(ArticleList[currentArticleId!!].Image)
            setHeart(ArticleList[currentArticleId!!].Status)
            edtxtTitle.isEnabled = FALSE
            edtxtContent.isEnabled = FALSE
            imgSiquiente.visibility = INVISIBLE
            imgAnterior.visibility = INVISIBLE
            imgFav.setOnClickListener {
                if(ArticleList[currentArticleId!!].Status){
                    setHeart(FALSE)
                }else{
                    setHeart(TRUE)
                }
            }
        }else{
            edtxtTitle.isEnabled = TRUE
            edtxtContent.isEnabled = TRUE
            imgSiquiente.visibility = VISIBLE
            imgAnterior.visibility = VISIBLE
            imageOptions = listOf(
                R.drawable.ic_heart_empty,
                R.drawable.ic_heart,
                R.drawable.ic_add,
                R.drawable.ic_check,
                R.drawable.ic_collections,
                R.drawable.ic_delete,
                R.drawable.ic_fastfood,
                R.drawable.ic_headset,
                R.drawable.ic_writer,
                R.drawable.ic_save,
                R.drawable.ic_reader,
                R.drawable.ic_plane,
                R.drawable.ic_delete,
                R.drawable.ic_next,
                R.drawable.ic_previous
            )
            imgFav.setImageResource(R.drawable.ic_save)
            setImgCounter()
            //go back to last image shown in imgMain
            imgAnterior.setOnClickListener {
                counter--
                setImgCounter()
            }
            //go to next image shown in imgMain
            imgSiquiente.setOnClickListener {
                counter++
                setImgCounter()
            }

            imgFav.setOnClickListener {
                var newArticle = Article(
                    imageOptions[counter],
                    edtxtTitle.text.toString(),
                    edtxtContent.text.toString(),
                    FALSE
                )
                if (currentArticleId!=null){
                    newArticle.Image = article!!.Image
                    newArticle.Status =article!!.Status
                    ArticleList[currentArticleId!!] = newArticle
                }else{
                    ArticleList.add(newArticle)
                }
                saveSharedPref(ArticleList)
                finish()
            }

        }
    }

    fun setArticle(){
        imgMain.setImageResource(article!!.Image)
        edtxtTitle.setText(article!!.Title)
        edtxtContent.setText(article!!.Content)
    }

    fun initView(){
        imgMain = findViewById(R.id.imgMain)
        imgAnterior = findViewById(R.id.imgAnterior)
        imgSiquiente = findViewById(R.id.imgSiguiente)
        edtxtTitle = findViewById(R.id.edtxtTitle)
        edtxtContent = findViewById(R.id.edtxtContent)
        imgFav = findViewById(R.id.imgFav)
        utype = intent.getBooleanExtra("usertype",TRUE)
        ArticleList = getSharedPref()
        if(intent.getParcelableExtra<Article>("currentArticle")!=null){
            article=intent.getParcelableExtra("currentArticle")!!
            currentArticleId=intent.getIntExtra("currentArticleId",0)
        }
        if(article!=null){
          setArticle()
        }
        setUserView()

        /*//DEPENDING ON USER TYPE
        if(utype){//Reader
            article?.let { setHeart(it.Status) }
            //set
            imgFav.setOnClickListener {
                article?.let { setHeart(it.Status) }
            }

        }else{//writer
            imgFav.setImageResource(R.drawable.ic_save)
            imageOptions = listOf(
                R.drawable.ic_heart_empty,
                R.drawable.ic_heart,
                R.drawable.ic_add,
                R.drawable.ic_check,
                R.drawable.ic_collections,
                R.drawable.ic_delete,
                R.drawable.ic_fastfood,
                R.drawable.ic_headset,
                R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_foreground,
                R.drawable.ic_writer,
                R.drawable.ic_save,
                R.drawable.ic_reader,
                R.drawable.ic_plane,
                R.drawable.ic_delete,
                R.drawable.ic_next,
                R.drawable.ic_previous
            )
            setImgCounter()
            //go back to last image shown in imgMain
            imgAnterior.setOnClickListener {
                counter--
                setImgCounter()
            }

            //go to next image shown in imgMain
            imgSiquiente.setOnClickListener {
                counter++
                setImgCounter()
            }

            //set
            imgFav.setOnClickListener {
                var newArticle = Article(
                    imageOptions[counter],
                    edtxtTitle.text.toString(),
                    edtxtContent.text.toString(),
                    FALSE
                )
                if (currentArticleId!=null){
                    ArticleList[currentArticleId!!] = newArticle
                }else{
                    ArticleList.add(newArticle)
                }
                saveSharedPref(ArticleList)
                finish()
            }
        }*/






    }

    private fun setHeart(status:Boolean){
        if (status){
            imgFav.setImageResource(R.drawable.ic_heart)
            ArticleList[counter].Status= TRUE
        }else{
            imgFav.setImageResource(R.drawable.ic_heart_empty)
            ArticleList[counter].Status= FALSE
        }
        saveSharedPref(ArticleList)
    }


    fun setImgCounter(){
        when(counter){
            -1 -> counter= imageOptions.size-1
            imageOptions.size -> counter=0
        }
        if(currentArticleId!=null){
            imgMain.setImageResource(article!!.Image)
        }else{
        imgMain.setImageResource(imageOptions[counter])}
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