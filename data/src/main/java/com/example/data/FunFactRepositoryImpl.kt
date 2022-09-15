package com.example.data

import com.example.domain.FunFactRepository
import com.example.local.FunFactLocal
import com.example.networking.FunFactNetworking

import kotlin.random.Random
import com.example.networking.utils.Status


class FunFactRepositoryImpl constructor(
    private val funFactNetworking: FunFactNetworking,
    private val funFactLocal: FunFactLocal
) : FunFactRepository {
    override suspend fun getRandomFunFact(hasConnection: Boolean): String {
        return if (hasConnection) {
            val remoteFunFact = funFactNetworking.getRandomFunFact()
            return when (remoteFunFact.status) {
                Status.SUCCESS ->{
                    val responseData = remoteFunFact.data?.value?.fact.toString()
                    funFactLocal.saveFunFact(responseData)
                    responseData
                }
                Status.ERROR -> remoteFunFact.message.toString()
                Status.LOADING -> "Loading..."
            }
        } else {
            val localData =  funFactLocal.getFunFact()
            localData[Random.nextInt(localData.size)]
        }
    }
}