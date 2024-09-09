package com.beatrice.starcast.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.beatrice.starcast.presentation.theme.StarCastTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    StarCastTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) {
            var text by remember { mutableStateOf("loading") }
            LaunchedEffect(true) {
                text = try {
                    Greeting().greeting()
                } catch (e: Exception) {
                    e.message ?: "Error"
                }
            }
            GreetingsView(text = text, modifier = Modifier.fillMaxSize())
        }

    }
}

@Composable
fun GreetingsView(modifier: Modifier = Modifier, text: String) {
    Box(modifier) {
        Text(text, modifier = Modifier.align(Alignment.Center))
    }
}