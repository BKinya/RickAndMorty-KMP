package com.beatrice.swcast.presentation.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.beatrice.swcast.domain.models.Character

@Composable
fun CharactersListComponent(
    modifier: Modifier = Modifier,
    characters: List<Character>
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(16.dp)
    ) {
        items(characters,
            key = { character -> character.name }) { character ->
            CharacterComponent(character = character)

        }

    }
}