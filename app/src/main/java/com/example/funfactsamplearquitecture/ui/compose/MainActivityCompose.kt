package com.example.funfactsamplearquitecture.ui.compose

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

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
                Text(
                    text = "Hola mundo, un mensaje muy largo para ver como de se a ve ",
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                )
            }
            Button(
                onClick = { Log.e("BTN","Si funciona")}
            ) {
                Text(text = "Refresh")
            }

        }

    }
}