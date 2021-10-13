package com.mariroco.p2_practica1.data.api

import com.mariroco.p2_practica1.data.dto.CocktailsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query

interface CocktailApi {
    @GET("json/v1/1/search.php")
    fun getCocktailsByName(@Query("s") name: String): Call<CocktailsResponse>
    //@POST
    //@PUT
    //@DELETE
}