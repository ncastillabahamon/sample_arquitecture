package com.example.funfactsamplearquitecture.ui.activities

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.funfactsamplearquitecture.ui.theme.FunFactSampleArquitectureTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SetupCardFacts("hola mundo")
        }
    }
}

@Composable
fun SetupCardFacts(fact: String) {
    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Blue),

    ){
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start =16.dp, end = 16.dp )
                    .height(100.dp),
                shape = RoundedCornerShape(corner = CornerSize(10.dp))
            ) {
                Text(text = "Hola mundo",)
            }
            Button(
                onClick = { Log.e("BTN","Si funciona")}
            ) {
                Text(text = "Refresh")
            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SetupCardFacts("demo")
}