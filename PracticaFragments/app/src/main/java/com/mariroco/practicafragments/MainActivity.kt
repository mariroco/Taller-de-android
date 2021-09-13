package com.mariroco.practicafragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    private lateinit var imgvImage: ImageView
    private lateinit var imgvPrevious: ImageView
    private lateinit var imgvNext: ImageView
    private lateinit var btnInfo: Button
    private lateinit var containerMain : ConstraintLayout
    private lateinit var containerFrag : FrameLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initVar()
    }

    fun initVar(){
        imgvImage = findViewById(R.id.imgv_image)
        imgvPrevious = findViewById(R.id.imgv_previous)
        imgvNext = findViewById(R.id.imgv_next)
        btnInfo = findViewById(R.id.btn_Info)
        containerMain = findViewById(R.id.container_main)
        containerFrag = findViewById(R.id.container)

        btnInfo.setOnClickListener {
            changeVisibility()
            supportFragmentManager.beginTransaction().add(R.id.container, DetailFragment()).addToBackStack(null).commit()

        }
    }

    public fun changeVisibility(){
        if (containerMain.visibility == VISIBLE){
            containerMain.visibility = GONE
            containerFrag.visibility = VISIBLE
        }else{
            containerMain.visibility = VISIBLE
            containerFrag.visibility = GONE
        }
    }

    fun replaceFragment(fragment: Fragment, tag: String) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment, tag).addToBackStack("").commit()
    }

}