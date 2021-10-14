package com.mariroco.p2_practica1.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity
@JsonClass(generateAdapter = true)
class Cocktail(
    @PrimaryKey(autoGenerate = false)
    val idDrink : Int= 0,
    @Json(name ="strDrink") val name: String = "",
    @Json(name ="strCategory") val catergory: String = "",
    @Json(name ="strDrinkThumb")val urlThumb: String = "",
    @Json(name ="strImageSource")val url: String? =""
) {
}