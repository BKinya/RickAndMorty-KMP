package com.beatrice.swcast.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.beatrice.swcast.presentation.theme.gold3
import com.beatrice.swcast.presentation.theme.smokeWhite
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import org.jetbrains.compose.resources.Resource
import org.jetbrains.compose.resources.painterResource
import swcast.composeapp.generated.resources.Res
import swcast.composeapp.generated.resources.ic_person


@Composable
fun ImageComponent(
    modifier: Modifier = Modifier,
    imageUrl: String) {

    val imageResource = asyncPainterResource(data = imageUrl)
    KamelImage(
        resource =  imageResource,
        modifier = modifier,
        contentDescription = "Character's image",
        onLoading = { progress ->
            CircularProgressIndicator(progress = {progress})
        },
        onFailure = {
            Box{
                Icon(
                    painter = painterResource(Res.drawable.ic_person),
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize(),
                    tint = smokeWhite
                )
                Text(text= "Oops! Something went wrong while loading the image",
                    style = TextStyle(
                        fontSize = 17.sp,
                        color = gold3
                    ),
                    modifier = Modifier.align(alignment = Alignment.Center)
                )
            }
        }
    )

}