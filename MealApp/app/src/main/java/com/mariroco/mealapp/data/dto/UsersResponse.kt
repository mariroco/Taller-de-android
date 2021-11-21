package com.mariroco.mealapp.data.dto

import com.mariroco.mealapp.domain.model.User
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UsersResponse(val categories: List<User>? = listOf())
