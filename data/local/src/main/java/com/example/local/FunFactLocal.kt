package com.example.local

interface FunFactLocal {
    suspend fun getFunFact(): List<String>
    suspend fun saveFunFact(funFact: String)
}