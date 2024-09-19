package com.beatrice.rickmortycast.data.remote.model

import kotlin.jvm.JvmInline

sealed interface CharacterNetworkResult<out T>{
    data class Success<T>(val result: T): CharacterNetworkResult<T>
    @JvmInline value class Error(val message:String): CharacterNetworkResult<Nothing>
}