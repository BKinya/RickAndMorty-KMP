package com.beatrice.starcast.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.beatrice.starcast.presentation.theme.StarCastTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    StarCastTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
        }
    }
}
