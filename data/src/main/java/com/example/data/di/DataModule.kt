package com.example.data

import com.example.domain.FunFactRepository
import com.example.local.FunFactLocal
import com.example.local.FunFactLocalImpl
import com.example.networking.ApiFunFact
import com.example.networking.FunFactNetworking
import org.koin.dsl.module

val dataModule = module {
    factory <FunFactRepository> { FunFactRepositoryImpl(get(), get()) }
    single<FunFactNetworking> { ApiFunFact() }
    single<FunFactLocal> { FunFactLocalImpl() }
}