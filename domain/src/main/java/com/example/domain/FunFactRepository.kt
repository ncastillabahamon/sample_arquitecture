package com.example.domain

interface FunFactRepository {
    suspend fun getRandomFunFact(hasConnection: Boolean): String
}