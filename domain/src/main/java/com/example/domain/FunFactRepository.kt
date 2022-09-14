package com.example.domain

interface FunFactRepository {
    fun getRandomFunFact(hasConnection:Boolean) : String
}