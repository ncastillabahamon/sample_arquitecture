package com.example.funfactsamplearquitecture.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.example.funfactsamplearquitecture.ui.compose.SetupCardFacts
import com.example.funfactsamplearquitecture.ui.viewmodels.SomeViewModel

class MainActivity : ComponentActivity() {

    private val theViewModel: SomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SetupCardFacts(theViewModel)
        }
    }
}


/*
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SetupCardFacts(theViewModel)
}*/