package com.beatrice.rickmortycast.data.remote.client

import com.beatrice.rickmortycast.data.remote.model.CharacterNetworkResult
import com.beatrice.rickmortycast.data.remote.model.CharactersResult
import io.github.aakira.napier.Napier
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse

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
    override suspend fun getCharacters(): CharacterNetworkResult<CharactersResult> {
        // TODO: Update this to use paging
        return try {
            val result: CharactersResult =
                httpClient.get(urlString = "https://rickandmortyapi.com/api/character").body()
            CharacterNetworkResult.Success(result = result)
        } catch (e: Exception) {
            Napier.e(e) {
                "Error fetching characters"
            }
            CharacterNetworkResult.Error(
                message = e.message ?: "Something went wrong while fetching characters"
            )
        }
    }
}
