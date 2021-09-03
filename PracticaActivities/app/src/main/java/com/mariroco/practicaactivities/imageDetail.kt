package com.mariroco.practicaactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.mariroco.practicaactivities.ImageStatus.*
import android.widget.Toast

class ImageDetail : AppCompatActivity() {
    private lateinit var image: Image

    private lateinit var imgvImage:ImageView
    private lateinit var imgvFavorite: ImageView

    private lateinit var txtvDate: TextView
    private lateinit var txtvPlace: TextView
    private lateinit var txtvNote: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_detail)

        initView()
        setView()
    }

    private fun initView(){
        image = intent.getParcelableExtra<Image>("selectedImg")?: Image()
        imgvImage = findViewById(R.id.imgv_image)
        imgvFavorite = findViewById(R.id.imgv_favorite)
        txtvDate = findViewById(R.id.txtv_date)
        txtvPlace = findViewById(R.id.txtv_place)
        txtvNote = findViewById(R.id.txtv_note)

        imgvImage.setOnClickListener {
            startActivity(Intent(this, ImageExpanded::class.java).apply {
                putExtra("selectedImg",image.image)
            })

        }

        imgvFavorite.setOnClickListener {
            if(image.status == LIKED){
                image.statusChange(UNLIKED)
                imgvFavorite.setImageResource(UNLIKED.resource)
            }else{
                image.statusChange(LIKED)
                imgvFavorite.setImageResource(LIKED.resource)
            }
        }
    }

    private fun setView(){
        image.image?.let { imgvImage.setImageResource(it) }
        image.status.resource?.let { imgvFavorite.setImageResource(it) }
        txtvDate.setText(getString(R.string.text_imageDate,image.date))
        txtvPlace.setText(getString(R.string.text_imagePlace,image.place))
        txtvNote.setText('"'+image.note+'"')

    }
}