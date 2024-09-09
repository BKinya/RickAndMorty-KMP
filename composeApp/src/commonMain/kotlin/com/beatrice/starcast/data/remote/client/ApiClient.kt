package com.beatrice.starcast.data.remote.client

import com.beatrice.starcast.data.remote.model.SearchResult
import kotlinx.coroutines.flow.Flow

interface ApiClient {
    /**
     * TODO: For now return a list of characters will get back to paging in a few
     */
   fun searchCharacter(query: String): String

}