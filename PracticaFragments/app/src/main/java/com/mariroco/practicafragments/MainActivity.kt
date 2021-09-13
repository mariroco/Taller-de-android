package com.mariroco.practicafragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    private lateinit var imgvImage: ImageView
    private lateinit var imgvPrevious: ImageView
    private lateinit var imgvNext: ImageView
    private lateinit var btnInfo: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun initVar(){
        imgvImage = findViewById(R.id.imgv_image)
        imgvPrevious = findViewById(R.id.imgv_previous)
        imgvNext = findViewById(R.id.imgv_next)
        btnInfo = findViewById(R.id.btn_Info)
    }

}