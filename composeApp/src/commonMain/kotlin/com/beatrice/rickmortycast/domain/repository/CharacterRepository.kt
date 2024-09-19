package com.beatrice.rickmortycast.domain.repository

import com.beatrice.rickmortycast.data.remote.model.CharacterNetworkResult
import com.beatrice.rickmortycast.data.remote.model.CharactersResult
import com.beatrice.rickmortycast.domain.models.Character
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {

    fun searchCharacter(query: String): String

    fun getAllCharacters(): Flow<CharacterNetworkResult<Character>>
}
