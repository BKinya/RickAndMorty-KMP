package com.beatrice.rickmortycast.data.repository

import com.beatrice.rickmortycast.data.remote.client.ApiClient
import com.beatrice.rickmortycast.data.remote.model.CharacterNetworkResult
import com.beatrice.rickmortycast.domain.models.Character
import com.beatrice.rickmortycast.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CharacterRepositoryImpl(
    private val apiClient: ApiClient
) : CharacterRepository {
    override fun searchCharacter(query: String): String {
        return apiClient.searchCharacter(query)
    }

    override fun getAllCharacters(): Flow<CharacterNetworkResult<Character>> = flow {
        val result = apiClient.getCharacters()
       val res = when(result){
            is CharacterNetworkResult.Error -> result
            is CharacterNetworkResult.Success -> {
                /**
                 * map character result to a list of characters
                 */
            }
        }
    }
}
