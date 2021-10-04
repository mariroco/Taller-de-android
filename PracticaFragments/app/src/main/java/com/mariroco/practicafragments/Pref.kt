package com.mariroco.practicafragments

import android.content.Context
import android.preference.PreferenceManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Pref (){
    private val LIST_KEY = "list_key"

    fun writeList(context: Context, list: List<Boolean>){
        var gson = Gson()
        var jsonString = gson.toJson(list)

        var pref= PreferenceManager.getDefaultSharedPreferences(context)
        var editor = pref.edit()
        editor.putString(LIST_KEY,jsonString)
        editor.apply()
    }

    fun readList(context: Context):List<Boolean>{
        var pref = PreferenceManager.getDefaultSharedPreferences(context);
        var jsonString = pref.getString(LIST_KEY,"")
        var gson = Gson()

        val type = object : TypeToken<ArrayList<Boolean>>() {}.type
        var list : ArrayList<Boolean> =gson.fromJson(jsonString,type)
        return list
    }

    inline fun <reified T> Gson.fromJson(json: String) = fromJson<T>(json, object: TypeToken<T>() {}.type)

    /*
    val SHARED_PREF= "mydb"
    val SHARED_IMG_STATUS= "false"

    val storage = context.getSharedPreferences(SHARED_PREF, 0)

    fun saveStatus(status:Boolean){
        storage.edit().putBoolean(SHARED_IMG_STATUS,status).apply()
    }

    fun getStatus():Boolean{
        return storage.getBoolean(SHARED_IMG_STATUS, false)
    }*/
}