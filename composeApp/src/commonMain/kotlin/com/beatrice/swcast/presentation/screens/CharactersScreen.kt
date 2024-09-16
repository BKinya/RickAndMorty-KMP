package com.beatrice.swcast.presentation.screens

import EmptyComponent
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.beatrice.swcast.presentation.components.CharactersListComponent
import com.beatrice.swcast.presentation.components.ErrorComponent
import com.beatrice.swcast.presentation.components.LoadingIndicator
import com.beatrice.swcast.presentation.state.CharacterUIState

@Composable
fun CharactersScreen(modifier: Modifier = Modifier,
                     characterUIState: CharacterUIState) {

    Scaffold(modifier = modifier) {
        contentPadding ->

        when(characterUIState){
            is CharacterUIState.Content -> CharactersListComponent(
                characters = characterUIState.characters
            )
            is CharacterUIState.Empty -> EmptyComponent(
                message = characterUIState.message,
                onRetry = {}
            )
            is CharacterUIState.Error -> ErrorComponent(
                message = characterUIState.message,
                onRetry = {})
            CharacterUIState.Loading -> LoadingIndicator()
        }
    }

}