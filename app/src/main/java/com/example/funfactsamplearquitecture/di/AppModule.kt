package com.example.funfactsamplearquitecture.di

import com.example.funfactsamplearquitecture.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel{ MainViewModel(get()) }
}