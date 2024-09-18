package com.beatrice.swcast.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.beatrice.swcast.presentation.theme.gold
import com.beatrice.swcast.presentation.theme.gold0
import com.beatrice.swcast.presentation.theme.gold1
import com.beatrice.swcast.presentation.theme.gold2
import com.beatrice.swcast.presentation.theme.gold3
import com.beatrice.swcast.presentation.theme.white

@Composable
fun ErrorComponent(modifier: Modifier = Modifier, message: String,
                   onRetry: () -> Unit) {

    Column(
        modifier = modifier.fillMaxSize().padding(22.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(80.dp)
                .background(
                    shape = CircleShape,
                    color = white
                )
        ) {
            Icon(
                Icons.Filled.Info,
                contentDescription = null,
                tint = gold0,
                modifier = Modifier.matchParentSize().align(Alignment.Center)
            )
        }
        Spacer(Modifier.height(19.dp))
        RegularText(text = message)
        Spacer(Modifier.height(32.dp))
        Button(
            onClick = onRetry,
            modifier = Modifier
                .size(
                width = 200.dp,
                height = 52.dp
            ),
            shape = RoundedCornerShape(18.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = gold1
            )
        ){
            Text(
                "Retry",
                modifier = Modifier,
                style = TextStyle(
                    fontSize = 30.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
            )
        }
    }

}