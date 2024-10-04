package com.beatrice.rickmortycast.data.util

import com.beatrice.rickmortycast.data.remote.model.CharacterDetails
import com.beatrice.rickmortycast.domain.models.Character

fun CharacterDetails.toDomain(): Character = Character(
    name = this.name,
    gender = this.gender,
    imageUrl = this.image,
    species = this.species,
    origin = this.origin.name,
    location = this.location.name ,
    status = this.status,
    episodes = this.episode

)