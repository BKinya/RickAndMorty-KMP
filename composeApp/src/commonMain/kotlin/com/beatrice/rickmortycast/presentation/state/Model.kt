package com.beatrice.rickmortycast.presentation.state

import com.beatrice.rickmortycast.domain.models.Character
import kotlin.jvm.JvmInline

sealed interface CharacterUIState{

    data object Loading: CharacterUIState
    data class Content(val characters: List<Character>): CharacterUIState
    @JvmInline value class Error(val message: String): CharacterUIState
    @JvmInline value  class Empty(val message: String = "Oops! No Characters Found"): CharacterUIState
}



sealed interface CharacterAction{
    data object FetchAllCharacters: CharacterAction

    /**
     * OnFinishTyping action is used to control typing text on
     * the start screen
     */
    data object FinishTyping: CharacterAction
}