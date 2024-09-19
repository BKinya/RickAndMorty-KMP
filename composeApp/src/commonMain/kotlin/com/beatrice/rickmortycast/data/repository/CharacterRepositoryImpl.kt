package com.beatrice.rickmortycast.data.repository

import androidx.paging.Pager
import androidx.paging.PagingData
import app.cash.paging.PagingConfig
import com.beatrice.rickmortycast.data.pagination.CharacterPagingSource
import com.beatrice.rickmortycast.data.remote.client.ApiClient
import com.beatrice.rickmortycast.domain.models.Character
import com.beatrice.rickmortycast.domain.repository.CharacterRepository
import io.github.aakira.napier.Napier
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

private const val PAGE_SIZE = 30
class CharacterRepositoryImpl(
    private val apiClient: ApiClient
) : CharacterRepository {
    override fun searchCharacter(query: String): String {
        return apiClient.searchCharacter(query)
    }

    override fun getAllCharacters(): Flow<PagingData<Character>> {
      return Pager(
           config = PagingConfig(
               pageSize = PAGE_SIZE,
               maxSize = PAGE_SIZE + (PAGE_SIZE * 2),
               enablePlaceholders = true
           ),
           pagingSourceFactory = {CharacterPagingSource(apiClient)}
       ).flow
    }
}
