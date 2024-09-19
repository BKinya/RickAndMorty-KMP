package com.beatrice.rickmortycast.presentation.components

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DoubleLoadingIndicator(modifier: Modifier = Modifier) {

    Box(modifier = modifier.size(100.dp)) {
        CircularProgressIndicator(
            modifier = Modifier.matchParentSize()
        )
        LoadingIndicator(modifier = Modifier.align(alignment = Alignment.Center))
    }
}

@Composable
fun LoadingIndicator(modifier: Modifier = Modifier) {
    val progressValue = 0.85f
    val infiniteTransition = rememberInfiniteTransition()

    val progressAnimationValue by infiniteTransition.animateFloat(
        initialValue = 0.0f,
        targetValue = progressValue,
        animationSpec = infiniteRepeatable(
            animation = tween(900, delayMillis = 100),
            repeatMode = RepeatMode.Reverse
        )
    )
    CircularProgressIndicator(
        modifier = modifier.size(70.dp),
        progress = {progressAnimationValue}
    )

}