package com.example.networking

import com.example.domain.FunFactEntity
import retrofit2.http.GET

interface FunFactApi {
    @GET("/")
    suspend fun getRandomFunFact(): FunFactEntity
}