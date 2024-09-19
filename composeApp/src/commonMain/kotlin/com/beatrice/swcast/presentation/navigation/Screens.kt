package com.beatrice.swcast.presentation.navigation

import com.beatrice.swcast.domain.models.Character
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

sealed class RickyMortyScreen(val route: String){
    data object CharacterScreen: RickyMortyScreen("character")
    data object CharacterDetailScreen: RickyMortyScreen("characterDetail?character={character}"){
        fun createRoute(character: Character): String {
            val json = Json.encodeToString(character)
            return route.replace("{character}", json)
        }
    }
}