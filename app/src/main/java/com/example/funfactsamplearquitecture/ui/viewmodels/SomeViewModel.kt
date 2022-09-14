package com.example.funfactsamplearquitecture.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel

class SomeViewModel: ViewModel() {

    var fact by mutableStateOf("Valor inicial desde viewModel")
    var currentColor by mutableStateOf(Color.Blue)
    val colorsBackground = arrayOf(Color(0xFF9CCC65), Color.Magenta, Color.Yellow, Color.Red)
    var count = 0

    fun changeFactFromServer(){
        //TODO mandar a traer la info del server ...
        fact = "este es nuevo texto desde viewmodel $count"
        currentColor = colorsBackground[count]
        count++

        if(count == colorsBackground.size)
            count = 0

    }
}