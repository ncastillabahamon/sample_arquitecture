package com.example.local.di

import androidx.room.Room
import com.example.local.FunFactLocal
import com.example.local.FunFactLocalImpl
import com.example.local.room.FunFactDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val localModule = module {
    single<FunFactLocal> { FunFactLocalImpl(get()) }
    single {
        Room.databaseBuilder(
            androidContext(),
            FunFactDatabase::class.java,
            "fun_fact_database"
        ).fallbackToDestructiveMigration().build()
    }
    single { get<FunFactDatabase>().funFactDao() }
}