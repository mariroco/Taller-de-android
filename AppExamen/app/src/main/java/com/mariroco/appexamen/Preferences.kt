package com.mariroco.appexamen

import android.content.Context

class Preferences(val context:Context) {
    val SHARED_NAME="usuarios"
    val SHARED_USERREAD="userread"
    val SHARED_USERWRITE="userwrite"
    val SHARED_PASSWORDWRITE="passwordwrite"
    val SHARED_PASSWORDREAD="passwordread"

    val storage = context.getSharedPreferences(SHARED_NAME,0)

    fun saveReader(username:String){
        storage.edit().putString(SHARED_USERREAD,username).apply()
    }
    fun saveWriter(username:String){
        storage.edit().putString(SHARED_USERWRITE,username).apply()
    }

    fun savePassword(password:String, utype:Boolean){
        var TYPE=""
        if(utype){
            TYPE =SHARED_PASSWORDREAD
        }else{
            TYPE=SHARED_PASSWORDWRITE
        }
        storage.edit().putString(TYPE,password).apply()
    }

    fun getReader():String{
        return  storage.getString(SHARED_USERREAD,"")!!
    }
    fun getWriter():String{
        return storage.getString(SHARED_USERWRITE,"").toString()
    }

    fun getPassword(type: Boolean):String{
        if (type) {
            return storage.getString(SHARED_PASSWORDREAD, "")!!
        }else{
            return storage.getString(SHARED_PASSWORDWRITE, "")!!
        }
    }

}