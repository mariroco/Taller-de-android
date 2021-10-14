package com.mariroco.p2_practica1.core.di

import android.content.Context
import androidx.room.Room
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
     @Provides
     @Singleton
     fun provideCocktailDb(@ApplicationContext context : Context) =
         Room.databaseBuilder(context, CocktailDb::class.java,"cocktails").build()
}