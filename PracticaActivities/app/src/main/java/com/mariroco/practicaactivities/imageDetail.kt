package com.mariroco.practicaactivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class ImageDetail : AppCompatActivity() {
    private lateinit var image: Image

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_detail)
        setView()
        Toast.makeText(this,image.note, Toast.LENGTH_SHORT).show()
    }

    private fun setView(){
        image = intent.getParcelableExtra<Image>("selectedImg")?: Image()
    }
}