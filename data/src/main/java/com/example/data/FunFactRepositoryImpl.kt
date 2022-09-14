package com.example.data

import com.example.domain.FunFactRepository
import com.example.local.FunFactLocal
import com.example.networking.FunFactNetworking


class FunFactRepositoryImpl constructor(
    private val funFactNetworking: FunFactNetworking,
    private val funFactLocal: FunFactLocal
) : FunFactRepository {
    override fun getRandomFunFact(hasConnection: Boolean): String =
        if (hasConnection) funFactNetworking.getRandomFunFact() else funFactLocal.getFunFact()
}