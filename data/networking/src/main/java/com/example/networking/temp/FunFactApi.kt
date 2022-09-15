package com.example.networking.temp

import retrofit2.http.GET

interface FunFactApi {
    @GET("/")
    suspend fun getRandomFunFact(): FunFactEntity
}