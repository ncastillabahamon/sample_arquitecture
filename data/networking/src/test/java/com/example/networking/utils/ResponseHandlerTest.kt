package com.example.networking.utils

import com.example.networking.CODE_401
import com.example.networking.CODE_401_ERROR
import com.example.networking.CODE_500
import com.example.networking.FunFactResponse
import com.example.networking.GENERIC_ERROR
import com.example.networking.MockFactResponse.FACT
import com.example.networking.MockFactResponse.factResponse
import com.example.networking.RETRY_ERROR
import com.example.networking.TIMEOUT_ERROR
import com.nhaarman.mockitokotlin2.mock
import java.net.HttpRetryException
import java.net.SocketTimeoutException
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.HttpException
import retrofit2.Response

@RunWith(JUnit4::class)
class ResponseHandlerTest {
    lateinit var responseHandler: ResponseHandler

    @Before
    fun setUp() {
        responseHandler = ResponseHandler()
    }

    @Test
    fun `when result is success return fact`() {
        val result = responseHandler.handleSuccess(factResponse)
        assertEquals(FACT, result.data?.value?.fact)
    }

    @Test
    fun `when response is calling api return Loading`() {
        val result = responseHandler.handleSuccess(Resource.loading(factResponse))
        assertEquals(Status.LOADING.name, result.data?.status?.name)
    }

    @Test
    fun `when exception code is 401 then return unauthorised`() {
        val httpException = HttpException(Response.error<FunFactResponse>(CODE_401, mock()))
        val result = responseHandler.handleException<FunFactResponse>(httpException)
        assertEquals(CODE_401_ERROR, result.message)
    }

    @Test
    fun `when exception code is no handled then return generic error message `() {
        val retryException = HttpRetryException(RETRY_ERROR, CODE_500)
        val result = responseHandler.handleException<FunFactResponse>(retryException)

        assertEquals(GENERIC_ERROR, result.message)
    }

    @Test
    fun `when timeout then return timeout error`() {
        val socketTimeoutException = SocketTimeoutException()
        val result = responseHandler.handleException<FunFactResponse>(socketTimeoutException)

        assertEquals(TIMEOUT_ERROR, result.message)
    }
}