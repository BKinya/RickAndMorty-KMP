package com.beatrice.swcast.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LoadingIndicator(modifier: Modifier = Modifier) {
    Box(modifier = modifier){
        CircularProgressIndicator(
            modifier = Modifier.size(100.dp)
        )
        CircularProgressIndicator(modifier = Modifier.size(80.dp))
    }

}