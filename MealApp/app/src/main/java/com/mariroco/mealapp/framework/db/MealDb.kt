package com.mariroco.mealapp.framework.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mariroco.mealapp.data.dao.MealDao
import com.mariroco.mealapp.domain.model.Category
import com.mariroco.mealapp.domain.model.Meal
import com.mariroco.mealapp.domain.model.User

@Database(
    entities = [
        User::class,
        Meal::class,
        Category::class],
    version = 1
)
abstract class MealDb : RoomDatabase() {
    abstract fun mealDao(): MealDao
}