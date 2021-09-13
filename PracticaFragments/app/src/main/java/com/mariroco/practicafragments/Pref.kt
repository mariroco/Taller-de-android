package com.mariroco.practicafragments

import android.content.Context

class Pref (val context: Context){
    val SHARED_PREF= "mydb"
    val SHARED_IMG_STATUS= "false"

    val storage = context.getSharedPreferences(SHARED_PREF, 0)

    fun saveStatus(status:Boolean){
        storage.edit().putBoolean(SHARED_IMG_STATUS,status).apply()
    }

    fun getStatus():Boolean{
        return storage.getBoolean(SHARED_IMG_STATUS, false)!!
    }
}