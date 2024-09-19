package com.beatrice.rickmortycast.di

import com.beatrice.rickmortycast.data.remote.client.ApiClient
import com.beatrice.rickmortycast.data.remote.client.ProdApiClient
import com.beatrice.rickmortycast.data.repository.CharacterRepositoryImpl
import com.beatrice.rickmortycast.domain.repository.CharacterRepository
import com.beatrice.rickmortycast.presentation.state.CharacterViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.bind
import org.koin.dsl.module

fun initKoin(config: KoinAppDeclaration? = null){
    startKoin {
        config?.invoke(this)
        modules(sharedModule)
    }
}

val sharedModule = module {
    viewModelOf(::CharacterViewModel)


    singleOf(::CharacterRepositoryImpl).bind<CharacterRepository>()
    singleOf(::ProdApiClient).bind<ApiClient>()
    single {
        HttpClient{
            expectSuccess = true
            install(Logging){
                logger = Logger.DEFAULT
               level = LogLevel.BODY
            }

            install(ContentNegotiation){
                json(Json {
                    ignoreUnknownKeys = true
                    isLenient = true
                })
            }
        }
    }
}