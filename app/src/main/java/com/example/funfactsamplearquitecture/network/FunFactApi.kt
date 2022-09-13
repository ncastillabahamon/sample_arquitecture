package com.example.funfactsamplearquitecture.network

import retrofit2.Response
import retrofit2.http.GET

interface FunFactApi {
    @GET("/")
    suspend fun getFact(): Response<FunFactEntity>
}