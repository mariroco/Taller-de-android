package com.mariroco.p2_practica1.core.di

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.mariroco.p2_practica1.framework.db.CocktailDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module //le indicamos que es un modulo
@InstallIn(SingletonComponent::class) //declaramos como se va a instalar
object DatabaseModule {

    //Variable para migración de datos, ponemos version inicial de bd y final
    private val MIGRATION_1_2 = object : Migration(1,2){
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("ALTER TABLE Cocktail ADD COLUMN alcoholic TEXT")
            database.execSQL("ALTER TABLE Cocktail ADD COLUMN instructions LONGTEXT")
        }
    }

    private val MIGRATION_2_3 = object : Migration(2,3){
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("CREATE TABLE IF NOT EXISTS User(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, name TEXT NOT NULL,token TEXT NOT NULL)")
        }
    }

     @Provides
     @Singleton
     fun provideCocktailDb(@ApplicationContext context : Context) =
         Room.databaseBuilder(context, CocktailDb::class.java,"cocktails").addMigrations(
             MIGRATION_1_2, MIGRATION_2_3).build()
}