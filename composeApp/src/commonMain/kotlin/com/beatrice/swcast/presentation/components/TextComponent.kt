package com.beatrice.swcast.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.beatrice.swcast.presentation.theme.gold
import com.beatrice.swcast.presentation.theme.gold0
import com.beatrice.swcast.presentation.theme.gold1
import com.beatrice.swcast.presentation.theme.gold2
import com.beatrice.swcast.presentation.theme.gold3


@Composable
fun BigTitle(
    modifier: Modifier = Modifier,
    title: String
) {
    val brush = remember {
        Brush.sweepGradient(colors = listOf(gold3, gold2, gold, gold1, gold0))
    }
    Text(
        title,
        modifier = modifier,
        style = TextStyle(
            fontSize = 48.sp,
            fontWeight = FontWeight.Thin,
            textAlign = TextAlign.Center,
            brush = brush
        )
    )
}


@Composable
fun SmallTitle(
    modifier: Modifier = Modifier,
    title: String
) {
    val brush = remember {
        Brush.sweepGradient(colors = listOf(gold3, gold2, gold, gold1, gold0))
    }
    Text(
        title,
        modifier = modifier,
        style = TextStyle(
            fontSize = 28.sp,
            fontWeight = FontWeight.Normal,
            brush = brush
        )
    )
}


@Composable
fun RegularText(
    modifier: Modifier = Modifier,
    text: String,
) {
    val brush = remember {
        Brush.sweepGradient(colors = listOf(gold0, gold1, gold, gold2, gold3))
    }
    Text(
        text,
        modifier = modifier,
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            brush = brush

        )
    )
}


@Composable
fun BoldText(
    modifier: Modifier = Modifier,
    text: String
) {
    Text(
        text,
        modifier = modifier,
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    )
}

@Composable
fun UnderLinedText(
    modifier: Modifier = Modifier,
    text: String
) {

    Box(
        modifier = modifier
    ) {
        Text(
            text,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
            style = TextStyle(
                fontSize = 27.sp,
                fontWeight = FontWeight.Light,
            )
        )

        HorizontalDivider(
            thickness = 1.5.dp,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.align(Alignment.BottomStart)
                .width(70.dp)
        )

    }

}

