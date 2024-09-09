package com.beatrice.starcast.data.remote.client

import io.ktor.client.HttpClient
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
}
