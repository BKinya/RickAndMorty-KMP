package com.beatrice.swcast.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.beatrice.swcast.domain.models.Character
import com.beatrice.swcast.presentation.components.CharactersListComponent
import com.beatrice.swcast.presentation.screens.CharacterDetailScreen
import com.beatrice.swcast.presentation.screens.CharactersScreen
import com.beatrice.swcast.presentation.screens.StartScreen
import com.beatrice.swcast.presentation.state.CharacterUIState
import com.beatrice.swcast.presentation.theme.SwTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

val testCharacter = Character(
    name = "Rick Sanchez",
    imageUrl = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
    status = "Alive",
    origin = "Earth (C-137)",
    location = "Citadel of Ricks",
    episodes = listOf("One", "Tow", "Three", "Fout", "Five", "Six", "Seven", "One", "Tow", "Three", "Fout", "Five", "Six", "Seven"),
    species = "Human",
    gender = "Male"
)

@Composable
fun App() {
    SwTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            CharactersScreen(
                characterUIState = CharacterUIState.Loading
            )
        }
    }
}

/**
 * Rename the project to RnM or sth closer
 */
