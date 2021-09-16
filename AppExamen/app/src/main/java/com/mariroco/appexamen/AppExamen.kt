package com.mariroco.appexamen

import android.app.Application

class AppExamen:Application() {
    companion object{
        lateinit var usersPref:Preferences
    }
    override fun onCreate() {
        super.onCreate()
        usersPref = Preferences(applicationContext)
    }
}