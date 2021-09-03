package com.mariroco.practicaactivities

import android.os.Parcelable
import com.mariroco.practicaactivities.ImageStatus.*
import kotlinx.parcelize.Parcelize

@Parcelize
class Image(
    var id: Int ?= null,
    var date: String = "",
    var place: String = "",
    var note: String = "",
    var image: Int ?= null,
    var status: ImageStatus = UNLIKED
):Parcelable{
    companion object{
        val images = arrayOf(
            Image(0,"22/03/2011","Japan","Inosuke, amén",(R.drawable.inosuke),LIKED),
            Image(1,"11/08/2021","Mexico","Fotograma de chica bailando",(R.drawable.girob4),UNLIKED),
            Image(2,"01/09/2021","Germany","Jana's avatas commission",(R.drawable.janaavatar),UNLIKED),
            Image(3,"23/10/2020","Mexico","Yoaltepuzlti rules",(R.drawable.yoalt),UNLIKED),
            Image(4,"01/09/2021","Mexico","El sol",(R.drawable.sol),UNLIKED),
            Image(5,"22/03/2017","USA","SVG carita enojada",(R.drawable.ic_angry),LIKED),
            Image(6,"11/08/2019","Mexico","SVG carita enamorada",(R.drawable.ic_loved),UNLIKED),
            Image(7,"01/09/2015","Ireland","SVG carita frustrada",(R.drawable.ic_frustrated),UNLIKED),
            Image(8,"23/10/2020","France","SVG carita emocionada",(R.drawable.ic_excited),UNLIKED),
            Image(9,"01/09/2019","Mexico","SVG carita enferma",(R.drawable.ic_sick),UNLIKED)

        )


    }

    fun getImage(arrayInt : Int) : Image { return images[arrayInt]}

    fun statusChange(status: ImageStatus) {
        images[this.id!!].status=status
    }

}