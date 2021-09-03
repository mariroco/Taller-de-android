package com.mariroco.practicaactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var image: Image
    private var counter: Int = 0

    //ImageViews
    private lateinit var imgvImage: ImageView
    private lateinit var imgvPrevious: ImageView
    private lateinit var imgvNext: ImageView

    //Buttons
    private lateinit var btnInfo: Button

    //OnCreate method
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        image = Image()
        initViews()
        setEvents()
    }

    //Initializes activity_main.xml
    fun initViews(){
        imgvImage = findViewById(R.id.imgv_image)
        imgvPrevious = findViewById(R.id.imgv_previous)
        imgvNext = findViewById(R.id.imgv_next)
        btnInfo = findViewById(R.id.btn_Info)
    }

    //Sets view elements' events (onclick...)
    fun setEvents(){
        imgvPrevious.setOnClickListener {
            counter--
            counterChanges()
        }

        imgvNext.setOnClickListener {
            counter++
            counterChanges()

        }

        btnInfo.setOnClickListener {
            image.getImage(counter)?.let{
                startActivity(Intent(this, ImageDetail::class.java).apply {
                putExtra("selectedImg",it)
                })
            }
        }
    }

    //Makes the counter turn around
    fun counterChanges(){
        when(counter){
            -1 -> counter = 2
            3 -> counter = 0
        }
        image.getImage(counter)?.let{ it.image?.let { it1 -> imgvImage.setImageResource(it1) } }
    }

}