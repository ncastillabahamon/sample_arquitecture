package com.example.networking

import com.example.networking.utils.Resource

interface FunFactNetworking {
   suspend fun getRandomFunFact(): Resource<FunFactResponse>
}