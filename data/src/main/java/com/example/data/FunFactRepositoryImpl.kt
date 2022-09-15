package com.example.data

import com.example.domain.FunFactRepository
import com.example.local.FunFactLocal
import com.example.networking.FunFactNetworking
import com.example.networking.utils.Status


class FunFactRepositoryImpl constructor(
    private val funFactNetworking: FunFactNetworking,
    private val funFactLocal: FunFactLocal
) : FunFactRepository {
    override suspend fun getRandomFunFact(hasConnection: Boolean): String {
        return if (hasConnection) {
            val remoteFunFact = funFactNetworking.getRandomFunFact()
            return when (remoteFunFact.status) {
                Status.SUCCESS -> remoteFunFact.data?.data?.fact.toString()
                Status.ERROR -> remoteFunFact.message.toString()
                Status.LOADING -> "Loading..."
            }
        } else {
            funFactLocal.getFunFact()
        }
    }
}