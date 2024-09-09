package com.beatrice.starcast.domain

interface CharacterRepository {
    /**
     * Here take data from the data source and return
     * it a manner that the UI expects TODO: later
     */

    fun searchCharacter(query: String): String
}