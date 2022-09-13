package com.example.funfactsamplearquitecture.network

class FunFactRepository constructor(private val apiService: FunFactApi) {

    suspend fun getFact(): NetworkState<FunFactEntity> {
        val response = apiService.getFact()
        return if (response.isSuccessful) {
            val responseBody = response.body()
            if (responseBody != null) {
                NetworkState.Success(responseBody)
            } else {
                NetworkState.Error(response)
            }
        } else {
            NetworkState.Error(response)
        }
    }
}