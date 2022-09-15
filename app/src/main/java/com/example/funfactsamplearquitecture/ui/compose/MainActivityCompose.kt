package com.example.funfactsamplearquitecture.ui.compose

import android.util.Log
import androidx.compose.animation.*
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.funfactsamplearquitecture.viewmodel.MainViewModel

@Composable
fun SetupCardFacts(factViewModel: MainViewModel) {

    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(color = factViewModel.currentColor),

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
                    .padding(start = 16.dp, end = 16.dp)
                    .height(100.dp),
                shape = RoundedCornerShape(corner = CornerSize(10.dp))
            ) {
                Text(
                    text = factViewModel.fact,
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                )
            }

        }
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)

        ) {
            AnimationButton(factViewModel)
           /* Button(
                onClick = {
                    Log.e("BTN","Si funciona")
                    factViewModel.changeFactFromServer()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
            ){
                Text(
                    text = "Refresh",
                    modifier = Modifier.animateContentSize()
                )
            }*/
        }

    }
}

@Composable
fun AnimationButton(changeFactFromServer: MainViewModel) {

    var isLoading by remember { mutableStateOf(false) }
    val text = if (isLoading) "Loanding... press again :)" else "Refresh"

    Button(
        onClick = {
            Log.e("BTN","Si funciona")
            isLoading = !isLoading
            changeFactFromServer.changeFactFromServer()
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
            .animateContentSize(
                animationSpec = tween(durationMillis = 300,
                    easing = LinearOutSlowInEasing))
    ){
        Text(
            text = text,
            modifier = Modifier.animateContentSize()
        )
    }

}


