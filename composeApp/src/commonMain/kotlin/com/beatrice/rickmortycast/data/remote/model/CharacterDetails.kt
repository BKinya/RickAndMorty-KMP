package com.beatrice.rickmortycast.data.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class CharacterDetails(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)