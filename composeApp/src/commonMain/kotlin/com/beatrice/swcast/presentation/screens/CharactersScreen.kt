package com.beatrice.swcast.presentation.screens


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.beatrice.swcast.presentation.components.CharactersListComponent
import com.beatrice.swcast.presentation.components.ErrorComponent
import com.beatrice.swcast.presentation.components.DoubleLoadingIndicator
import com.beatrice.swcast.presentation.state.CharacterUIState
import io.github.aakira.napier.Napier

@Composable
fun CharactersScreen(modifier: Modifier = Modifier,
                     characterUIState: CharacterUIState) {

        when(characterUIState){
            is CharacterUIState.Content -> CharactersListComponent(
                modifier = modifier,
                characters = characterUIState.characters,
                searchQuery = "",
                onQueryChanged = {
                    Napier.d { "Query is $it" }
                }
            )
            is CharacterUIState.Empty -> ErrorComponent(
                message = characterUIState.message,
                onRetry = {

                }
            )
            is CharacterUIState.Error -> ErrorComponent(
                modifier = modifier,
                message = characterUIState.message,
                onRetry = {
                    Napier.d { "Retry Clicked" }
                })
            CharacterUIState.Loading -> {
               LoadingScreen(modifier = modifier)
            }
        }

}