package com.beatrice.swcast.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.beatrice.swcast.domain.models.Character
import com.beatrice.swcast.presentation.components.BoldText
import com.beatrice.swcast.presentation.components.ImageComponent
import com.beatrice.swcast.presentation.components.RegularText
import com.beatrice.swcast.presentation.components.UnderLinedText
import com.beatrice.swcast.presentation.theme.gold
import com.beatrice.swcast.presentation.theme.white
import org.jetbrains.compose.resources.painterResource
import swcast.composeapp.generated.resources.Res
import swcast.composeapp.generated.resources.ic_arrow

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CharacterDetailScreen(
    modifier: Modifier = Modifier,
    character: Character
) {
    Scaffold(modifier = modifier,
        topBar = {

        }) {
        Column(
            modifier = Modifier
                .fillMaxSize()

        ) {
            ImageComponent(
                modifier = Modifier.fillMaxWidth(),
                imageUrl = character.imageUrl
            )

            Spacer(Modifier.height(16.dp))
            FlowRow {
                BoldText(text = character.status)
                SpacerComponent()
                DotComposable()
                SpacerComponent()
                BoldText(text = character.gender)
                SpacerComponent()
                DotComposable()
                SpacerComponent()
                BoldText(text = character.species)
                SpacerComponent()
                DotComposable()
                SpacerComponent()
                BoldText(text = character.origin)
                SpacerComponent()
                DotComposable()
                SpacerComponent()
                BoldText(text = character.location)
            }

            Spacer(Modifier.height(16.dp))
            UnderLinedText(text = "Films")
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                character.episodes.forEach { episode ->
                    Row{
                        Icon(painter = painterResource(Res.drawable.ic_arrow),
                            contentDescription = null,
                            tint = white
                        )
                        Spacer(modifier.width(4.dp))
                        RegularText(text = episode)
                    }
                }
            }



        }
    }
}

@Composable
fun DotComposable(modifier: Modifier = Modifier) {
    Box(modifier = modifier.size(20.dp).background(
        shape = CircleShape,
        color = gold
    ))
}

@Composable
fun SpacerComponent(modifier: Modifier = Modifier) {
    Spacer(modifier.width(4.dp))
}