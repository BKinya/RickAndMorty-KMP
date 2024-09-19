package com.beatrice.rickmortycast.data.pagination

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.beatrice.rickmortycast.data.remote.client.ApiClient
import com.beatrice.rickmortycast.domain.models.Character
import io.github.aakira.napier.Napier

private const val STARTING_PAGE_INDEX = 1

class CharacterPagingSource(
    private val apiClient: ApiClient
) : PagingSource<Int, Character>() {
    override fun getRefreshKey(state: PagingState<Int, Character>): Int? {
        return state.anchorPosition?.let { anchorPos ->
            val anchorPage = state.closestPageToPosition(anchorPosition = anchorPos)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        return try {
            val page = params.key ?: 1
            val characters = apiClient.getCharacters(page)
         return LoadResult.Page(
                data = characters,
                prevKey = if (page == STARTING_PAGE_INDEX) null else page - 1,
                nextKey = if (characters.isEmpty()) null else page + 1
            )
        } catch (e: Exception) {
            Napier.e(e, tag = "FETCHING_CHARACTERS") { "Something went wrong while loading data ${e.message}" }
            LoadResult.Error(e)
        }
    }
}


