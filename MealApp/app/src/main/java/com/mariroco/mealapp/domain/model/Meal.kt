package com.mariroco.mealapp.domain.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize
import org.w3c.dom.ProcessingInstruction

@Parcelize
@Entity
@JsonClass(generateAdapter = true)
class Meal(
    @PrimaryKey(autoGenerate = false) val idMeal: Int = 0,
    @Json(name = "strMeal") val name: String = "",
    @Json(name = "strCategory") val category: String = "",
    @Json(name = "strMealThumb") val urlThumb: String? = "",
    @Json(name = "strArea") val area: String = "",
    @Json(name = "strInstructions") val recipe: String? = "",

    @Json(name = "strIngredient1") val ing1 : String?="",
    @Json(name = "strIngredient2") val ing2 : String?="",
    @Json(name = "strIngredient3") val ing3 : String?="",
    @Json(name = "strIngredient4") val ing4 : String?="",
    @Json(name = "strIngredient5") val ing5 : String?="",
    @Json(name = "strIngredient6") val ing6: String?="",
    @Json(name = "strIngredient7") val ing7 : String?="",
    @Json(name = "strIngredient8") val ing8 : String?="",
    @Json(name = "strIngredient9") val ing9 : String?="",
    @Json(name = "strIngredient10") val ing10 : String?="",
    @Json(name = "strIngredient11") val ing11 : String?="",
    @Json(name = "strIngredient12") val ing12 : String?="",
    @Json(name = "strIngredient13") val ing13 : String?="",
    @Json(name = "strIngredient14") val ing14 : String?="",
    @Json(name = "strIngredient15") val ing15 : String?="",
    @Json(name = "strIngredient16") val ing16 : String?="",
    @Json(name = "strIngredient17") val ing17 : String?="",
    @Json(name = "strIngredient18") val ing18 : String?="",
    @Json(name = "strIngredient19") val ing19 : String?="",
    @Json(name = "strIngredient20") val ing20 : String?="",

    @Json(name = "strMeasure1") val me1 : String ?="",
    @Json(name = "strMeasure2") val me2 : String ?="",
    @Json(name = "strMeasure3") val me3 : String ?="",
    @Json(name = "strMeasure4") val me4 : String ?="",
    @Json(name = "strMeasure5") val me5 : String ?="",
    @Json(name = "strMeasure6") val me6 : String ?="",
    @Json(name = "strMeasure7") val me7 : String ?="",
    @Json(name = "strMeasure8") val me8 : String ?="",
    @Json(name = "strMeasure9") val me9 : String ?="",
    @Json(name = "strMeasure10") val me10 : String ?="",
    @Json(name = "strMeasure11") val me11 : String ?="",
    @Json(name = "strMeasure12") val me12 : String ?="",
    @Json(name = "strMeasure13") val me13 : String ?="",
    @Json(name = "strMeasure14") val me14 : String ?="",
    @Json(name = "strMeasure15") val me15 : String ?="",
    @Json(name = "strMeasure16") val me16 : String ?="",
    @Json(name = "strMeasure17") val me17 : String ?="",
    @Json(name = "strMeasure18") val me18 : String ?="",
    @Json(name = "strMeasure19") val me19 : String ?="",
    @Json(name = "strMeasure20") val me20 : String ?=""

):Parcelable {
    val ingredients : String
        get()  {
            var temp =""
            val list = mutableListOf("$me1 $ing1", "$me2 $ing2", "$me3 $ing3", "$me4 $ing4","$me5 $ing5", "$me6 $ing6","$me7 $ing7", "$me8 $ing8","$me9 $ing9", "$me10 $ing10", "$me11 $ing11", "$me12 $ing12", "$me13 $ing13", "$me14 $ing14", "$me15 $ing15", "$me16 $ing16", "$me17 $ing17", "$me18 $ing18", "$me19 $ing19", "$me20 $ing20")
            var i=1
            while (list[i].isNotEmpty() && list[i].isNotBlank() && list[i]!=" "){
                temp+="*${list[i]} \n"
                i++
            }
            return (temp)
        }
    //get() = ing.toString()
}

