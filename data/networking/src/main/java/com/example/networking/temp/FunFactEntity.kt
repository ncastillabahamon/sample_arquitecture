package com.example.networking.temp

import com.google.gson.annotations.SerializedName

data class FunFactEntity(
    @SerializedName("data")
    val fact: Fact
) {
    data class Fact(
        var id: String,
        var fact: String
    )
}