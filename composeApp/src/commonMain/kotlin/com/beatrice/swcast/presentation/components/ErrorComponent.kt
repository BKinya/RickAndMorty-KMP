package com.beatrice.swcast.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.beatrice.swcast.presentation.theme.white

@Composable
fun ErrorComponent(modifier: Modifier = Modifier, message: String,
                   onRetry: () -> Unit) {

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(70.dp)
                .background(
                    shape = CircleShape,
                    color = white
                )
        ) {
            Icon(
                Icons.Filled.Info,
                contentDescription = null
            )
        }
        Spacer(Modifier.height(12.dp))
        RegularText(text = message)
        Spacer(Modifier.height(12.dp))
        Button(
            onClick = onRetry
        ){
            Text("Retry")
        }
    }

}