package com.beatrice.swcast.presentation.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun SwTheme(content: @Composable () -> Unit) {
    val colorScheme = swColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}
