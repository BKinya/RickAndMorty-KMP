package com.beatrice.swcast.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.beatrice.swcast.domain.models.Character
import com.beatrice.swcast.presentation.screens.CharactersScreen
import com.beatrice.swcast.presentation.screens.LoadingScreen
import com.beatrice.swcast.presentation.state.CharacterUIState
import com.beatrice.swcast.presentation.theme.SwTheme

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
                characterUIState =
                CharacterUIState.Content(
                    characters = listOf(
                        testCharacter,
                        testCharacter.copy(name = "Morty Smith"),
                        testCharacter.copy(name = "Summer Smith"),
                        testCharacter.copy(name = "Beth Smith"),
                        testCharacter.copy(name = "Jerry Smith"),
                        testCharacter.copy(name = "Abadango Cluster Princess"),
                        testCharacter.copy(name = "Abradolf Lincler")
                    )
                )
            )
        }
    }
}

/**
 * todo: Rename the project to RnM or sth closer
 */
