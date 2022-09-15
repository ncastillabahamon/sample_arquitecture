package com.example.networking

import com.example.domain.FunFactEntity
import com.example.networking.utils.Resource

interface FunFactNetworking {
   suspend fun getRandomFunFact(): Resource<FunFactEntity>
}