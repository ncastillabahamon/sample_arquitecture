package com.example.data

import com.example.domain.FunFactRepository
import com.example.local.FunFactLocal
import com.example.networking.temp.FunFactApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class FunFactRepositoryImpl constructor(
    private val funFactApi: FunFactApi,
    private val funFactLocal: FunFactLocal
) : FunFactRepository {
    override suspend fun getRandomFunFact(hasConnection: Boolean): String {
       return if (hasConnection){
            funFactApi.getRandomFunFact().fact.fact
        }else{
            funFactLocal.getFunFact()
        }
    }
}