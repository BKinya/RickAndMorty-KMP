package com.beatrice.rickmortycast.presentation.navigation.destinations


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.beatrice.rickmortycast.domain.models.Character
import com.beatrice.rickmortycast.presentation.components.CharactersListComponent
import com.beatrice.rickmortycast.presentation.components.ErrorComponent
import com.beatrice.rickmortycast.presentation.state.CharacterUIState
import io.github.aakira.napier.Napier

@Composable
fun CharactersScreen(modifier: Modifier = Modifier,
                     characterUIState: CharacterUIState,
                     navigateToDetailScreen: (Character) -> Unit) {

        when(characterUIState){
            is CharacterUIState.Content -> CharactersListComponent(
                modifier = modifier,
                characters = characterUIState.characters,
                searchQuery = "",
                onQueryChanged = {
                    Napier.d { "Query is $it" }
                },
                navigateToDetailScreen = navigateToDetailScreen
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