package com.beatrice.swcast.presentation.screens

import EmptyComponent
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.beatrice.swcast.presentation.components.CharactersListComponent
import com.beatrice.swcast.presentation.components.ErrorComponent
import com.beatrice.swcast.presentation.components.LoadingIndicator
import com.beatrice.swcast.presentation.state.CharacterUIState
import io.github.aakira.napier.Napier

@Composable
fun CharactersScreen(modifier: Modifier = Modifier,
                     characterUIState: CharacterUIState) {

    Scaffold(modifier = modifier,
        topBar = {
            /**
             * Could this resize as the user scrolls up... no no use
             */
        }) { _ ->

        when(characterUIState){
            is CharacterUIState.Content -> CharactersListComponent(
                characters = characterUIState.characters
            )
            is CharacterUIState.Empty -> ErrorComponent(
                message = characterUIState.message,
                onRetry = {

                }
            )
            is CharacterUIState.Error -> ErrorComponent(
                message = characterUIState.message,
                onRetry = {
                    Napier.d { "Retry Clicked" }
                })
            CharacterUIState.Loading -> LoadingIndicator()
        }
    }

}