package com.beatrice.rickmortycast.presentation.navigation.destinations

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.beatrice.rickmortycast.presentation.components.BigTitle
import com.beatrice.rickmortycast.presentation.components.TypeWriterText

@Composable
fun LoadingScreen(modifier: Modifier = Modifier,
                  onFinishTyping: () -> Unit) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TypeWriterText(
            text = "Ricky and Morty Cast",
            onFinishTyping = onFinishTyping
        ){  text ->
            BigTitle(
                title = text,
                modifier = Modifier.padding(32.dp)
            )
        }
    }
}