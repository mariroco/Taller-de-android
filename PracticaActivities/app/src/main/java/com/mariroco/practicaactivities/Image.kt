package com.mariroco.practicaactivities

import android.os.Parcelable
import com.mariroco.practicaactivities.ImageStatus.*
import kotlinx.parcelize.Parcelize

@Parcelize
class Image(
    var date: String = "",
    var place: String = "",
    var note: String = "",
    var image: Int ?= null,
    var status: ImageStatus = UNLIKED
):Parcelable{
    companion object{
        val images = arrayOf(
            Image("02/09/2021","León","Ya no quiero trabajar",(R.drawable.ic_empty_heart),UNLIKED),
            Image("28/06/2021","Guadalajara","FUIMONOS",(R.drawable.ic_filled_heart),UNLIKED),
            Image("29/06/2021","San Jose del Cabo","Estoy endeudada, ayudaaa",(R.drawable.ic_launcher_background),UNLIKED)
        )
    }

    fun getImage() = images.firstOrNull { (it.date == "02/09/2021")}
    fun getImage(arrayInt : Int) : Image { return images[arrayInt]}


}