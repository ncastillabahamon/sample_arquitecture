package com.example.networking

import com.example.networking.utils.Resource
import com.example.networking.utils.ResponseHandler

internal class FunFactNetWorkingImp constructor(
    private val funFactApi: FunFactApi,
    private val responseHandler: ResponseHandler
) : FunFactNetworking {
    override suspend fun getRandomFunFact(): Resource<FunFactEntity> {
        return try {
            val response =funFactApi.getRandomFunFact()
            responseHandler.handleSuccess(response)
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }
}