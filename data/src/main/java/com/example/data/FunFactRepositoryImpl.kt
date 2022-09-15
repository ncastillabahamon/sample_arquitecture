package com.example.data

import com.example.domain.FunFactRepository
import com.example.local.FunFactLocal
import com.example.networking.FunFactNetworking
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.random.Random


class FunFactRepositoryImpl constructor(
    private val funFactNetworking: FunFactNetworking,
    private val funFactLocal: FunFactLocal
) : FunFactRepository {
    override suspend fun getRandomFunFact(hasConnection: Boolean): String {
        return withContext(Dispatchers.IO) {
            if (hasConnection) {
                val response = funFactNetworking.getRandomFunFact()
                funFactLocal.saveFunFact(response)
                return@withContext "API $response"
            } else {
                val localData =  funFactLocal.getFunFact()
                return@withContext "DB ${localData[Random.nextInt(localData.size)]}"
            }
        }
    }
}