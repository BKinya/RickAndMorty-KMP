package com.beatrice.swcast.presentation.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.beatrice.swcast.presentation.theme.black
import com.beatrice.swcast.presentation.theme.gold
import com.beatrice.swcast.presentation.theme.gold0
import com.beatrice.swcast.presentation.theme.gold2
import com.beatrice.swcast.presentation.theme.gold3
import com.beatrice.swcast.presentation.theme.gold1


@Composable
fun BigTitle(
    modifier: Modifier = Modifier,
    title: String
) {
    val brush = remember {
        Brush.sweepGradient(colors = listOf(gold3, gold2, black, gold, gold2, gold3, black))
    }
    Text(title,
        modifier = modifier,
        style = TextStyle(
           fontSize = 56.sp,
            fontWeight = FontWeight.Thin,
            textAlign = TextAlign.Center,
            brush = brush
        )
    )
}


@Composable
fun SmallTitle(modifier: Modifier = Modifier,
               title: String) {
    Text(title,
        modifier = modifier,
        style = TextStyle(
            fontSize = 27.sp,
            fontWeight = FontWeight.SemiBold
        )
    )
}


@Composable
fun RegularText(modifier: Modifier = Modifier,
                text: String) {
    Text(text,
        modifier = modifier,
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal
        )
    )
}


@Composable
fun BoldText(modifier: Modifier = Modifier,
             text: String) {
    Text(text,
        modifier = modifier,
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal
        )
    )
}

