package com.beatrice.rickmortycast.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharactersResult(
    val info: Info,
    @SerialName("results")
    val characterDetails: List<CharacterDetails>
)