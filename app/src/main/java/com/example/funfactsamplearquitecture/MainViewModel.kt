package com.example.funfactsamplearquitecture

import androidx.lifecycle.ViewModel
import com.example.domain.FunFactRepository

class MainViewModel constructor(funFactRepository: FunFactRepository) : ViewModel() {

    private val _funFact = funFactRepository.getRandomFunFact(true)
    val funFact: String
        get() = _funFact
}