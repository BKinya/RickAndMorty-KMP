package com.beatrice.rickmortycast.data.remote.model

import kotlin.jvm.JvmInline
import kotlin.jvm.Strictfp

sealed interface NetworkResult{
    data class Content<T>(val data: T): NetworkResult
    @JvmInline value class Error(val message: String): NetworkResult

}