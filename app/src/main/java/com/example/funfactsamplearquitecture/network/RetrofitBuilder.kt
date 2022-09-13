package com.example.funfactsamplearquitecture.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private const val baseUrl = "https://asli-fun-fact-api.herokuapp.com"

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService: FunFactApi = getRetrofit().create(FunFactApi::class.java)
}