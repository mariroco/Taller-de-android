package com.mariroco.practicaactivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class ImageExpanded : AppCompatActivity() {
    private lateinit var imgvImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_expanded)
        init()
    }

    fun init(){
        imgvImage = findViewById(R.id.imgv_image)
        imgvImage.setImageResource(intent.getIntExtra("selectedImg",0))
    }
}