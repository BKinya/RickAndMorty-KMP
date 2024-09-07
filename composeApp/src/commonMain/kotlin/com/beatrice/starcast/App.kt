package com.beatrice.starcast

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colors.background
        ) {
            var text by remember { mutableStateOf("loading") }
            LaunchedEffect(true) {
                text = try {
                    Greeting().greeting()
                } catch (e: Exception) {
                    e.message ?: "Error"
                }
            }
            GreetingsView(text = text)

        }
    }
}

@Composable
fun GreetingsView(modifier: Modifier = Modifier, text: String) {
    Text(text)
}