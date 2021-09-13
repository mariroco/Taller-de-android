package com.mariroco.practicafragments

import android.app.Application

class PracticaFragmentos : Application(){
    companion object{
        lateinit var prefs:Pref
    }
    override fun onCreate() {
        super.onCreate()
        prefs = Pref(applicationContext)
    }
}