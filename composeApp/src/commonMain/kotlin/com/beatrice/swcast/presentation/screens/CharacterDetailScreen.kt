package com.beatrice.swcast.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.beatrice.swcast.domain.models.Character
import com.beatrice.swcast.presentation.components.ImageComponent
import com.beatrice.swcast.presentation.components.RegularText
import com.beatrice.swcast.presentation.components.SmallTitle
import com.beatrice.swcast.presentation.components.UnderLinedText
import com.beatrice.swcast.presentation.theme.black30
import com.beatrice.swcast.presentation.theme.gold
import com.beatrice.swcast.resources.Res
import com.beatrice.swcast.resources.ic_back
import com.beatrice.swcast.resources.ic_forward
import org.jetbrains.compose.resources.painterResource


@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun CharacterDetailScreen(
    modifier: Modifier = Modifier,
    character: Character,
    onNavigateBack: () -> Unit
) {
    Scaffold(modifier = modifier,
        topBar = {
            Row(
                modifier = Modifier.fillMaxWidth()
                    .background(
                        color = black30
                    ).padding(horizontal = 8.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                Icon(
                    contentDescription = null,
                    painter = painterResource(Res.drawable.ic_back),
                    tint = gold,
                    modifier = Modifier
                        .size(40.dp)
                        .clickable(onClick = onNavigateBack)
                )
                SmallTitle(title = character.name)


            }
        }) { contentPadding ->
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState())
                .padding(contentPadding)
        ) {
            Box(
                modifier = Modifier.fillMaxWidth()
                    .height(300.dp)
            ) {
                ImageComponent(
                    imageUrl = character.imageUrl
                )
            }
            Spacer(Modifier.height(8.dp))

            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                FlowRow(
                    modifier = Modifier
                ) {
                    RegularText(text = character.status)
                    SpacerComponent()
                    RegularText(text = character.species)
                    SpacerComponent()
                    RegularText(text = character.gender)
                    SpacerComponent()
                    RegularText(text = character.origin)
                    SpacerComponent()
                    RegularText(text = character.location)

                }

                Spacer(Modifier.height(16.dp))
                UnderLinedText(text = "Episodes")
                Spacer(Modifier.height(20.dp))
                Column(
                    verticalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    character.episodes.forEach { episode ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(bottom = 8.dp, start = 12.dp, end = 12.dp)
                        ) {
                            Icon(
                                painter = painterResource(Res.drawable.ic_forward),
                                contentDescription = null,
                                modifier = Modifier.size(16.dp),
                                tint = gold
                            )
                            Spacer(modifier.width(8.dp))
                            RegularText(text = episode)
                        }
                    }
                }

            }


        }
    }
}

@Composable
fun DotComponent(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Spacer(modifier = Modifier.height(17.dp))
        Box(
            modifier = Modifier.size(4.dp).background(
                shape = CircleShape,
                color = gold
            )
        )
    }
}

@Composable
fun SpacerComponent(modifier: Modifier = Modifier) {
    Spacer(modifier.width(12.dp))
    DotComponent()
    Spacer(modifier.width(12.dp))
}