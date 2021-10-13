package com.mariroco.p2_practica1.data.dto

import com.mariroco.p2_practica1.domain.model.Cocktail
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CocktailsResponse(val drinks: List<Cocktail>? = listOf())