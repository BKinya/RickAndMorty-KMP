package com.beatrice.swcast.data.remote.client

interface ApiClient {
    /**
     * TODO: For now return a list of characters will get back to paging in a few
     */
    fun searchCharacter(query: String): String
}
