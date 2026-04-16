package com.beatrice.rickmortycast.domain.repository

import androidx.paging.PagingData
import com.beatrice.rickmortycast.domain.models.Character
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {

    fun searchCharacter(query: String): String

    fun getAllCharacters(): Flow<PagingData<Character>>

    /**
     * Get all episodes where a character is featured
     */
   suspend fun getCharacterEpisodes(episodeUrls: List<String>): Result<List<String>>
}
