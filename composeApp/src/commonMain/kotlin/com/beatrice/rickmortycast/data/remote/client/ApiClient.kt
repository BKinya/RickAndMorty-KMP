package com.beatrice.rickmortycast.data.remote.client

import com.beatrice.rickmortycast.data.remote.model.CharacterNetworkResult
import com.beatrice.rickmortycast.data.remote.model.CharactersResult

interface ApiClient {

    fun searchCharacter(query: String): String

   suspend fun getCharacters(): CharacterNetworkResult<CharactersResult>
}
