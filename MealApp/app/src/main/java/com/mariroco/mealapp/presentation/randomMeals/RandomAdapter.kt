package com.mariroco.mealapp.presentation.randomMeals

import android.annotation.SuppressLint
import com.mariroco.mealapp.domain.model.Meal

@SuppressLint("NotifyDataSetChanged")
class RandomAdapter {
    private var meal: Meal = Meal()
    lateinit var listener : (meal: Meal) -> Unit

    fun addData(meal: Meal) {
        this.meal = meal
    }

}
