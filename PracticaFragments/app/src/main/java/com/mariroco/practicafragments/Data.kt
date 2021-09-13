package com.mariroco.practicafragments

import android.app.Application
import android.content.Context
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Data (
    var image: Int,
    var note: String,
    var status: Boolean = false
) : Parcelable {
    companion object{
        val list = arrayListOf<Data>(
            Data((R.drawable.uno),"1"),
            Data((R.drawable.dos),"2"),
            Data((R.drawable.tres),"3"),
            Data((R.drawable.cuatro),"4"),
            Data((R.drawable.cinco),"5")
        )
    }
}



