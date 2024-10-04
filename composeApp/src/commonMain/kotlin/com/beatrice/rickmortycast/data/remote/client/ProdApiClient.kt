package com.beatrice.rickmortycast.data.remote.client

import com.beatrice.rickmortycast.data.remote.model.CharactersResult
import com.beatrice.rickmortycast.data.remote.model.Episode
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

        return query
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

    override suspend fun getEpisode(episodeUrl: String): Episode {
        val episode = httpClient.get(episodeUrl).body<Episode>()
        return episode
    }
}
