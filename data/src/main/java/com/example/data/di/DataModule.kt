package com.example.data.di

import com.example.data.FunFactRepositoryImpl
import com.example.domain.FunFactRepository
import com.example.local.di.localModule
import com.example.networking.di.networkingModule
import org.koin.dsl.module

val dataModule = module {
    includes(networkingModule, localModule)
    factory <FunFactRepository> { FunFactRepositoryImpl(get(), get()) }
}