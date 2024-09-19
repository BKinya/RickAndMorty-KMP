package com.beatrice.rickmortycast.data.remote.client

import com.beatrice.rickmortycast.domain.models.Character

interface ApiClient {

    fun searchCharacter(query: String): String

   suspend fun getCharacters(page: Int): List<Character>
}
