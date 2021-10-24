package com.mariroco.mealapp.data.dto

import com.mariroco.mealapp.domain.model.Meal
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MealsResponse(val meals: List<Meal>? = listOf())

