package com.mariroco.practicafragments

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity() {

    private lateinit var imgvImage: ImageView
    private lateinit var imgvPrevious: ImageView
    private lateinit var imgvNext: ImageView
    private lateinit var btnInfo: Button
    private lateinit var containerMain : ConstraintLayout
    private lateinit var containerFrag : FrameLayout
    private var mp: MediaPlayer? = null
    lateinit var imageList: List<Image>
    var counter : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        changeImage()
    }

    fun initView(){
        imgvImage = findViewById(R.id.imgv_image)
        imgvPrevious = findViewById(R.id.imgv_previous)
        imgvNext = findViewById(R.id.imgv_next)
        btnInfo = findViewById(R.id.btn_Info)
        containerMain = findViewById(R.id.container_main)
        containerFrag = findViewById(R.id.container)
        imageList = getSharedPref()


        btnInfo.setOnClickListener {
            changeVisibility()
            supportFragmentManager.beginTransaction().add(R.id.container, DetailFragment()).addToBackStack(null).commit()

        }

        imgvNext.setOnClickListener {
            counter++
            changeImage()

        }

        imgvPrevious.setOnClickListener {
            counter--
            changeImage() }
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

    private fun changeImage(){
        mp?.stop()
        when(counter){
            -1 -> {
                counter = 4
                playSound(R.raw.cinco)
            }
            0-> playSound(R.raw.uno)
            1-> playSound(R.raw.dos)
            2-> playSound(R.raw.tres)
            3-> playSound(R.raw.cuatro)
            4-> playSound(R.raw.cinco)
            5 -> {
                counter = 0
                playSound(R.raw.uno)}
        }
        imgvImage.setImageResource(imageList[counter].image)
    }

    fun replaceFragment(fragment: Fragment, tag: String) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment, tag).addToBackStack("DetailFragment").commit()
    }

    fun saveSharedPref(images: List<Image>){
        val prefEditor = PreferenceManager.getDefaultSharedPreferences(this).edit()
        val jsonString = Gson().toJson(images)
        prefEditor.putString("images",jsonString).apply()
    }

    fun playSound(sound:Int){
        mp=MediaPlayer.create(this,sound)
        with(mp) { this?.start() }
    }

    private fun getSharedPref(): List<Image> {
        val gson = Gson()
        val myType = object : TypeToken<List<Image>>() {}.type

        val preferences = PreferenceManager.getDefaultSharedPreferences(this)
        val jsonString = preferences.getString("images", null)
        return if(jsonString!=null){
            gson.fromJson(jsonString, myType)
        }else{
            listOf(
                Image((R.drawable.uno),"numbuh 1",false),
                Image((R.drawable.dos),"numbuh 2",false),
                Image((R.drawable.tres),"numbuh 3",false),
                Image((R.drawable.cuatro),"numbuh 4",false),
                Image((R.drawable.cinco),"numbuh 5",false)
            )
        }
    }

}

