package com.beatrice.swcast.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Character(
    val imageUrl: String,
    val name: String,
    val status: String,
    val species: String,
    val gender: String,
    val origin: String,
    val location: String,
    val episodes: List<String>,

)
