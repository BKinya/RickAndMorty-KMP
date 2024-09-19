package com.beatrice.rickmortycast.data.remote.client

import com.beatrice.rickmortycast.data.remote.model.CharactersResult
import com.beatrice.rickmortycast.data.util.toDomain
import com.beatrice.rickmortycast.domain.models.Character
import io.github.aakira.napier.Napier
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ProdApiClient(
    private val httpClient: HttpClient
) : ApiClient {
    override fun searchCharacter(query: String): String {
        /**
         * httpClient.get() returns a response...
         *
         * take that response and make it a search result
         *
         * Error handling and other things later
         */
        return "Halllo KMP"
    }

    /**
     * TODO: Extract base url to an env property
     */
    override suspend fun getCharacters(page: Int): List<Character> {
        val result =
            httpClient.get(urlString = "https://rickandmortyapi.com/api/character?page=$page")
        val characters = result.body<CharactersResult>().characterDetails.map { it.toDomain() }
        return characters

    }
}
