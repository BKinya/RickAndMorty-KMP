package com.beatrice.starcast.data.repository

import com.beatrice.starcast.data.remote.client.ApiClient
import com.beatrice.starcast.domain.CharacterRepository

class CharacterRepositoryImpl(
   private val apiClient: ApiClient
): CharacterRepository {
    override fun searchCharacter(query: String): String {
       return apiClient.searchCharacter(query)
    }
}