package com.example.networking.di

import com.example.networking.ApiFunFact
import com.example.networking.FunFactNetworking
import org.koin.dsl.module

val networkingModule = module {
    single<FunFactNetworking> { ApiFunFact() }
}