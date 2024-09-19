package com.beatrice.rickmortycast.data.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class CharactersResult(
    val info: Info,
    val characterDetails: List<CharacterDetails>
)