package com.example.networking

import com.example.domain.Fact
import com.google.gson.annotations.SerializedName

data class FunFactEntity(
    @SerializedName("data")
    val value: Fact
)