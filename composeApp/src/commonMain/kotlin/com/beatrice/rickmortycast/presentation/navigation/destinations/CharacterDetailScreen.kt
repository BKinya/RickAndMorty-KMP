package com.beatrice.rickmortycast.presentation.navigation.destinations

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
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
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.beatrice.rickmortycast.domain.models.Character
import com.beatrice.rickmortycast.presentation.components.ErrorTextComponent
import com.beatrice.rickmortycast.presentation.components.ImageComponent
import com.beatrice.rickmortycast.presentation.components.LoadingIndicator
import com.beatrice.rickmortycast.presentation.components.RegularText
import com.beatrice.rickmortycast.presentation.components.SmallTitle
import com.beatrice.rickmortycast.presentation.components.UnderLinedText
import com.beatrice.rickmortycast.presentation.state.CharacterAction
import com.beatrice.rickmortycast.presentation.state.CharacterViewModel
import com.beatrice.rickmortycast.presentation.state.UiState
import com.beatrice.rickmortycast.presentation.theme.darkGrey30
import com.beatrice.rickmortycast.presentation.theme.gold
import com.beatrice.rickmortycast.resources.Res
import com.beatrice.rickmortycast.resources.ic_back
import com.beatrice.rickmortycast.resources.ic_forward
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CharacterDetailScreen(
    modifier: Modifier = Modifier,
    character: Character,
    onNavigateBack: () -> Unit,
    characterViewModel: CharacterViewModel = koinViewModel()
) {

    LaunchedEffect(true) {
        characterViewModel.sendEvent(CharacterAction.FetchCharacterEpisodes(character.episodes))
    }
    val episodesState = characterViewModel.episodesUiState.collectAsStateWithLifecycle().value
    Scaffold(modifier = modifier,
        topBar = {
            Row(
                modifier = Modifier.fillMaxWidth()
                    .background(
                        color = darkGrey30
                    ).padding(horizontal = 12.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                Icon(
                    contentDescription = null,
                    painter = painterResource(Res.drawable.ic_back),
                    tint = gold,
                    modifier = Modifier
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
                modifier = Modifier.padding(12.dp)
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
                    EpisodesComponent(uiState = episodesState)

                }

            }


        }
    }
}

@Composable
fun EpisodesComponent(
    modifier: Modifier = Modifier,
    uiState: UiState
) {
    when(uiState){
        is UiState.Content<*> -> {
            val episodes = uiState.data as List<String>
            ShowEpisodesList(
                modifier = modifier,
                episodes = episodes)
        }
       is  UiState.Default -> {
           // Do nothing
       }
        is  UiState.Empty -> {
            ErrorTextComponent(
                modifier = modifier,
                text = uiState.message)
        }
        is UiState.Error -> {
            ErrorTextComponent(
                modifier = modifier,
                text = uiState.message)
        }
        is UiState.Loading -> {
            Box(modifier = modifier.fillMaxWidth().padding(top = 40.dp, bottom = 40.dp)) {
                LoadingIndicator(
                    modifier = Modifier
                        .size(65.dp).align(Alignment.Center)
                )
            }
        }
    }

}




@Composable
fun ShowEpisodesList(modifier: Modifier = Modifier,
                     episodes: List<String>) {
    var displayedEpisodes by remember {
        mutableStateOf(emptyList<String> ())
    }
    LaunchedEffect(true){
        var index = 1
        while (index <= episodes.size) {
            displayedEpisodes = episodes.subList(0, index)
            index += 1
            delay(50)

        }
    }
    displayedEpisodes.forEach { episode ->

        AnimatedVisibility(visible =true,
            enter = fadeIn() ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier.padding(bottom = 8.dp, start = 12.dp, end = 12.dp)
            ) {
                Icon(
                    painter = painterResource(Res.drawable.ic_forward),
                    contentDescription = null,
                    modifier = Modifier.size(16.dp),
                    tint = gold
                )
                Spacer(modifier.width(8.dp))
                RegularText(text = episode, textAlign = TextAlign.Start)
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