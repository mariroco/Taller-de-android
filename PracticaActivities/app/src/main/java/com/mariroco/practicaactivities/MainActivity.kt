package com.mariroco.practicaactivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initVars()
        initViews()
        setEvents()
    }

    //Initializes all var values
    fun initVars(){}

    //Initializes activity_main.xml
    fun initViews(){}

    //Sets view elements' events (onclick...)
    fun setEvents(){}
}