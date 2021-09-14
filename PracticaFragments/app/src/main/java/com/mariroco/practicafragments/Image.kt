package com.mariroco.practicafragments

class Image (
    var image: Int,
    var note: String,
    var status: Boolean = false
){
    companion object{
        val list = arrayListOf<Image>(
            Image((R.drawable.uno),"1"),
            Image((R.drawable.dos),"2"),
            Image((R.drawable.tres),"3"),
            Image((R.drawable.cuatro),"4"),
            Image((R.drawable.cinco),"5")
        )
    }
}



