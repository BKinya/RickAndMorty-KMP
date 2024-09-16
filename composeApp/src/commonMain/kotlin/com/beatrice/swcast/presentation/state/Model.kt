package com.beatrice.swcast.presentation.state

import com.beatrice.swcast.domain.models.Character
import kotlin.jvm.JvmInline

sealed interface CharacterUIState{

    data object Loading: CharacterUIState
    data class Content(val characters: List<Character>): CharacterUIState
    @JvmInline value class Error(val message: String): CharacterUIState
    @JvmInline value  class Empty(val message: String = "Oops! No Characters Found"): CharacterUIState
}



sealed interface CharacterActions{

}