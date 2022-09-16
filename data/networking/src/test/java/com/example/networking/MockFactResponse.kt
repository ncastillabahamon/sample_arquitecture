package com.example.networking

import com.example.domain.Fact

const val CODE_401_ERROR = "Unauthorised"
const val CODE_500 = 500
const val CODE_401 = 401
const val GENERIC_ERROR = "Something went wrong"
const val TIMEOUT_ERROR = "Timeout"
const val RETRY_ERROR = "retry"

object MockFactResponse {
    const val ID = "123123"
    const val FACT = "fact value"
    val factResponse = FunFactResponse(Fact(ID, FACT))
}