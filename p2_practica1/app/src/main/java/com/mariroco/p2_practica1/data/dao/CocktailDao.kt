package com.mariroco.p2_practica1.data.dao

import androidx.room.*
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.OnConflictStrategy.REPLACE
import com.mariroco.p2_practica1.domain.model.Cocktail

@Dao
interface CocktailDao {

    @Query("SELECT * FROM Cocktail WHERE name LIKE :filter")
    fun getCocktailsByName (filter: String): List<Cocktail>

    //En caso de discrepancia reemplaza los cockteles de la bd
    @Insert(onConflict = REPLACE)
    fun saveCocktails(cocktails: List<Cocktail>): List<Long>

    @Update
    fun updateCocktail(cocktail: Cocktail): Int

    /*@Delete
    fun deleteCocktail(cocktail: Cocktail)*/
}