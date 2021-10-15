package com.mariroco.p2_practica1.framework.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mariroco.p2_practica1.data.dao.CocktailDao
import com.mariroco.p2_practica1.domain.model.Cocktail

//la version debe de cambiar cada vez que se haga una modificación a la bd
@Database(entities=[Cocktail::class],version = 3)
abstract class CocktailDb : RoomDatabase() {
    abstract fun cocktailDao(): CocktailDao
}