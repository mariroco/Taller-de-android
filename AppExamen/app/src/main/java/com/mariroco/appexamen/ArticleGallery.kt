package com.mariroco.appexamen

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.ImageView

class ArticleGallery : AppCompatActivity() {
    private lateinit var imgMain : ImageView
    private lateinit var imgAnterior : ImageView
    private lateinit var imgSiquiente : ImageView
    private lateinit var containerFrag : FrameLayout
    private lateinit var imgFav : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_gallery)
        initView()
    }

    fun initView(){
        imgMain = findViewById(R.id.imgMain)
        imgAnterior = findViewById(R.id.imgAnterior)
        imgSiquiente = findViewById(R.id.imgSiguiente)
        containerFrag = findViewById(R.id.containerFrag)
        imgFav = findViewById(R.id.imgFav)

        //go back to last image shown in imgMain
        imgAnterior.setOnClickListener {  }

        //go to next image shown in imgMain
        imgSiquiente.setOnClickListener {  }

        //set
        imgFav.setOnClickListener {  }
    }
}