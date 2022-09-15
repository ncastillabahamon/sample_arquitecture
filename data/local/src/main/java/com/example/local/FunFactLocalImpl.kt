package com.example.local

import com.example.local.room.FunFactDao
import com.example.local.room.FunFactEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

internal class FunFactLocalImpl constructor(
    private val funFactDao: FunFactDao
) : FunFactLocal {
    override suspend fun getFunFact(): List<String>  = funFactDao.getFunFactEntity().map { it.mapToDomain() }
    override suspend fun saveFunFact(funFact: String) {
        withContext(Dispatchers.IO) {
            funFactDao.insert(FunFactEntity(funFact = funFact))
        }
    }
}
