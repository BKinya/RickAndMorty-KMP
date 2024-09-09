package com.beatrice.starcast.presentation

import com.beatrice.starcast.data.repository.CharacterRepositoryImpl
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText

/**
 * GOAL: Imoplement the first request
 */

class Greeting {

    suspend fun greeting(): String{
        val response = "some text"
       return response
    }


}