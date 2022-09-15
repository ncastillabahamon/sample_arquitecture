package com.example.networking.di

import com.example.networking.BuildConfig
import com.example.networking.FunFactApi
import com.example.networking.FunFactNetWorkingImp
import com.example.networking.FunFactNetworking
import com.example.networking.utils.ResponseHandler
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkingModule = module {
    factory { provideOkHttpClient(get()) }
    factory { provideFunFactApi(get()) }
    factory { provideLoggingInterceptor() }
    single { provideRetrofit(get()) }
    factory <FunFactNetworking> { FunFactNetWorkingImp(get(), get()) }
    factory { ResponseHandler() }
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl(BuildConfig.API_URL).client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
    return OkHttpClient().newBuilder().addInterceptor(loggingInterceptor).build()
}

fun provideLoggingInterceptor(): HttpLoggingInterceptor {
    val logger = HttpLoggingInterceptor()
    logger.level = HttpLoggingInterceptor.Level.BASIC
    return logger
}

fun provideFunFactApi(retrofit: Retrofit): FunFactApi = retrofit.create(FunFactApi::class.java)
