package com.beatrice.rickmortycast.presentation.state

import kotlin.jvm.JvmInline

sealed interface UiState{
    data object Default: UiState
    data object Loading: UiState
    data class Content<T>(val data: List<T>): UiState
    @JvmInline value class Error(val message: String): UiState
    @JvmInline value  class Empty(val message: String = "Oops! No Data Found"): UiState
}



sealed interface CharacterAction{
    /**
     * OnFinishTyping action is used to control typing text on
     * the start screen
     */
    data object FinishTyping: CharacterAction

    data object FetchAllCharacters: CharacterAction

    /**
     * Fetch all episodes in which a character is features
     */
    data class FetchCharacterEpisodes(
        val episodeUrls: List<String>
    ): CharacterAction
}