package com.example.local

internal class FunFactLocalImpl : FunFactLocal {
    override suspend fun getFunFact(): String = "DB A FULL NASA SPACE SUIT COSTS \$12,000,000."
}