package com.beatrice.rickmortycast.data.repository

import com.beatrice.rickmortycast.data.remote.client.ApiClient
import com.beatrice.rickmortycast.domain.repository.CharacterRepository

class CharacterRepositoryImpl(
    private val apiClient: ApiClient
) : CharacterRepository {
    override fun searchCharacter(query: String): String {
        return apiClient.searchCharacter(query)
    }
}
