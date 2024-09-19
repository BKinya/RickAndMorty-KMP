package com.beatrice.rickmortycast.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchResult(
    val count: Int,
    val next: String?,
    val previous: String?,
    @SerialName("results")
    val characters: List<Character>
)
