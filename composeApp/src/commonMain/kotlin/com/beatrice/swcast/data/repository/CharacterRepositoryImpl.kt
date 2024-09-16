package com.beatrice.swcast.data.repository

import com.beatrice.swcast.data.remote.client.ApiClient
import com.beatrice.swcast.domain.repository.CharacterRepository

class CharacterRepositoryImpl(
    private val apiClient: ApiClient
) : CharacterRepository {
    override fun searchCharacter(query: String): String {
        return apiClient.searchCharacter(query)
    }
}
