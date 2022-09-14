package com.example.funfactsamplearquitecture.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.example.domain.FunFactRepository

class MainViewModel constructor(private val funFactRepository: FunFactRepository) : ViewModel() {

    var fact by mutableStateOf(funFactRepository.getRandomFunFact(true))
    var currentColor by mutableStateOf(Color.Blue)
    val colorsBackground = arrayOf(Color(0xFF9CCC65), Color.Magenta, Color.Yellow, Color.Red)
    var count = 0

    fun changeFactFromServer(){

        fact = "${funFactRepository.getRandomFunFact(false)} $count"
        currentColor = colorsBackground[count]
        count++

        if(count == colorsBackground.size)
            count = 0

    }



}