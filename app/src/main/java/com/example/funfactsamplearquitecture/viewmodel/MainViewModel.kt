package com.example.funfactsamplearquitecture.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.example.domain.FunFactRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel constructor(private val funFactRepository: FunFactRepository) : ViewModel() {

    var toggleConnection = false
    var fact by mutableStateOf("")

    init {
        CoroutineScope(Dispatchers.IO).launch {
            fact = funFactRepository.getRandomFunFact(true)
        }
    }
    var currentColor by mutableStateOf(Color.Blue)
    val colorsBackground = arrayOf(Color(0xFF9CCC65), Color.Magenta, Color.Yellow, Color.Red)
    var count = 0

    fun changeFactFromServer() {
        CoroutineScope(Dispatchers.IO).launch {
            fact = "${funFactRepository.getRandomFunFact(toggleConnection)} $count"
            currentColor = colorsBackground[count]
            count++
            toggleConnection = !toggleConnection

            if (count == colorsBackground.size)
                count = 0
        }

    }



}