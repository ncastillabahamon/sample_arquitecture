package com.example.networking

import retrofit2.http.GET

interface FunFactApi {
    @GET("/")
    suspend fun getRandomFunFact(): FunFactEntity
}