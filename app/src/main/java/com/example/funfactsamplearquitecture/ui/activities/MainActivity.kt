package com.example.funfactsamplearquitecture.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.funfactsamplearquitecture.ui.compose.SetupCardFacts
import com.example.funfactsamplearquitecture.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val mainViewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SetupCardFacts(mainViewModel.funFact)
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SetupCardFacts("demo")
}