package com.example.networking

import com.example.networking.utils.Resource
import com.example.networking.utils.ResponseHandler
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.HttpException

@RunWith(JUnit4::class)
class FunFactNetWorkingImpTest {
    private val responseHandler = ResponseHandler()
    private lateinit var funFactApi: FunFactApi
    private lateinit var repository: FunFactNetworking
    private val funFact = MockFactResponse.factResponse
    private val funFactResponse = Resource.success(funFact)
    private val errorResponse = Resource.error(CODE_401_ERROR, null)


    @Before
    fun setUp() {
        funFactApi = mock()
        repository = FunFactNetWorkingImp(
            funFactApi, responseHandler
        )
    }

    @Test
    fun `test getRandomFunFact with valid requested, then Fact is returned`() {
        runBlocking {
            whenever(funFactApi.getRandomFunFact()).thenReturn(funFact)
            assertEquals(funFactResponse, repository.getRandomFunFact())
        }
    }


    @Test
    fun `test getRandomFunFact with invalid request, then error is returned`() {
        val mockException: HttpException = mock()
        whenever(mockException.code()).thenReturn(CODE_401)
        runBlocking {
            whenever(funFactApi.getRandomFunFact()).thenThrow(mockException)
            assertEquals(errorResponse, repository.getRandomFunFact())
        }
    }

}