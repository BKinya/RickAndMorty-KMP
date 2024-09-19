package com.beatrice.rickmortycast.presentation.navigation

import com.beatrice.rickmortycast.domain.models.Character
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

sealed class RickMortyScreen(val route: String){
    data object CharacterScreen: RickMortyScreen("character")
    data object CharacterDetailScreen: RickMortyScreen("characterDetail?character={character}"){
        fun createRoute(character: Character): String {
            val json = Json.encodeToString(character)
            return route.replace("{character}", json)
        }
    }
}