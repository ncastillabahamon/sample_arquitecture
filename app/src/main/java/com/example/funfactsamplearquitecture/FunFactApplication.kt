package com.example.funfactsamplearquitecture

import android.app.Application
import com.example.data.dataModule
import com.example.funfactsamplearquitecture.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class FunFactApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin {
            androidLogger()
            androidContext(this@FunFactApplication)
            modules(listOf(appModule, dataModule))
        }
    }
}