package com.beatrice.swcast.domain.models

data class Character(
    val imageUrl: String,
    val name: String,
    val status: String,
    val species: String,
    val gender: String,
    val origin: String,
    val location: String,
    val locationResidents: List<String>,
    val episodes: List<String>,

)
