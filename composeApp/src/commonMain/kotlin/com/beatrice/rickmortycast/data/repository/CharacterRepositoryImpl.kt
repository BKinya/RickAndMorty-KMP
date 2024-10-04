package com.beatrice.rickmortycast.data.repository

import androidx.paging.Pager
import androidx.paging.PagingData
import app.cash.paging.PagingConfig
import com.beatrice.rickmortycast.data.pagination.CharacterPagingSource
import com.beatrice.rickmortycast.data.remote.client.ApiClient
import com.beatrice.rickmortycast.domain.models.Character
import com.beatrice.rickmortycast.domain.repository.CharacterRepository
import io.github.aakira.napier.Napier
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

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
            pagingSourceFactory = { CharacterPagingSource(apiClient) }
        ).flow
    }

    /**
     * Get all episodes where a character is featured
     */
    override  fun getCharacterEpisodes(episodeUrls: List<String>): Flow<List<String>> = flow{
        val episodes: List<String> = episodeUrls.map { url ->
            getOneEpisode(url)
        }
      emit(episodes)
    }

   private suspend fun getOneEpisode(episodeUrl: String): String {
     return   try {
            val episode = apiClient.getEpisode(episodeUrl)
         episode.name
        } catch (e: CancellationException) {
            Napier.e("Cancelling coroutines ${e.message}", tag = "FETCHING_EPISODES")
            throw e
        } catch (e: Exception){
            Napier.e("an error occurred ${e.message}", tag = "FETCHING_EPISODES")
            ""
        }
    }
}



