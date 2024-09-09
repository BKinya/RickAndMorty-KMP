package com.beatrice.starcast.presentation.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun StarCastTheme(content: @Composable () -> Unit) {
    val colorScheme = starCastColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}
