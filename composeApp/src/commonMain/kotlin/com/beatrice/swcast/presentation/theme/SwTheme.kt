package com.beatrice.swcast.presentation.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun SwTheme(content: @Composable () -> Unit) {
    val colorScheme = rNmColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}
