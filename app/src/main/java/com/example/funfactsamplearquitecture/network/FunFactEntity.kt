package com.example.funfactsamplearquitecture.network

data class FunFactEntity(
    val data: Fact
) {
    data class Fact(
        var id: String,
        var fact: String
    )
}