package com.beatrice.swcast.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.beatrice.swcast.domain.models.Character
import com.beatrice.swcast.presentation.theme.darkGrey30
import com.beatrice.swcast.presentation.theme.gold

@Composable
fun CharactersListComponent(
    modifier: Modifier = Modifier,
    characters: List<Character>
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            Row(
                modifier = Modifier.fillMaxWidth()
                    .background(
                        color = darkGrey30
                    ).padding(horizontal = 12.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                SmallTitle(title = "Ricky n Morty Cast")
                Icon(
                    contentDescription = null,
                    imageVector = Icons.Filled.Search,
                    tint = gold,
                    modifier = Modifier

                )


            }
        }
    ) { contentPadding ->
        LazyVerticalGrid(
            modifier = modifier.padding(8.dp),
            contentPadding = contentPadding,
            columns = GridCells.Adaptive(minSize = 144.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(characters,
                key = { character -> character.name }) { character ->
                CharacterComponent(character = character)
            }


        }
    }
}