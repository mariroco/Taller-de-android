package com.mariroco.mealapp.data.dao

import androidx.room.*
import com.mariroco.mealapp.domain.model.Meal
import androidx.room.Query
import com.mariroco.mealapp.domain.model.Category
import com.mariroco.mealapp.domain.model.User


@Dao
interface MealDao {
    @Query("SELECT * FROM Meal WHERE name LIKE :filter")
    fun getMealsByName(filter: String): List<Meal>

    @Query("SELECT * FROM Category")
    fun getCategories(): List<Category>

    @Query("SELECT * FROM User")
    fun getUsers(): List<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveUser(users: List<User>): List<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveMeals(meals: List<Meal>): List<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveCategories(categories: List<Category>): List<Long>

}