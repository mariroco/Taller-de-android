package com.mariroco.mealapp.data.api

import com.mariroco.mealapp.data.dto.CategoriesResponse
import com.mariroco.mealapp.data.dto.MealsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MealApi {
    @GET("json/v1/1/categories.php")
    fun getCategories():Call<CategoriesResponse>

    @GET("json/v1/1/search.php")
    fun getMealsByName(@Query("s") name: String): Call<MealsResponse>

}