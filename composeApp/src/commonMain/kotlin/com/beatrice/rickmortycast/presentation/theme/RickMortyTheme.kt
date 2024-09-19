package com.beatrice.rickmortycast.presentation.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun RickMortyTheme(content: @Composable () -> Unit) {
    val colorScheme = rickMortyColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}
