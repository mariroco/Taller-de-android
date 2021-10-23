package com.mariroco.mealapp.domain.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize
import org.w3c.dom.ProcessingInstruction

@Parcelize
//@Entity
//@JsonClass(generateAdapter = true)
class Meal(
    //@PrimaryKey(autoGenerate = false)
    val idMeal : Int= 0,
    //@Json(name = "strMeal")
    val name: String = "",
    //@Json(name="strCategory")
    val category: String="",
    //@Json(name="strMealThumb")
    val urlThumb:  String? = "",
    //@Json(name="strArea")
    val area: String = "",
    //@Json(name = "strInstructions")
    val recipe: String?=""

):Parcelable {
    val ingredients : String =""
}