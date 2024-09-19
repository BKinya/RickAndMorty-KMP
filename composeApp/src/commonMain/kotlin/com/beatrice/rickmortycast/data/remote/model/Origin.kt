package com.beatrice.rickmortycast.data.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class Origin(
    val name: String,
    val url: String
)