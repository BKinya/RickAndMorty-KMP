package com.beatrice.swcast.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.beatrice.swcast.presentation.screens.StartScreen
import com.beatrice.swcast.presentation.theme.SwTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable

fun App() {
    SwTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            StartScreen()
        }
    }
}
