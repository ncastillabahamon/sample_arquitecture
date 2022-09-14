package com.example.local.di

import com.example.local.FunFactLocal
import com.example.local.FunFactLocalImpl
import org.koin.dsl.module

val localModule = module {
    single<FunFactLocal> { FunFactLocalImpl() }
}