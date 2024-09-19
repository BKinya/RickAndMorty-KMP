package com.beatrice.swcast.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.beatrice.swcast.domain.models.Character
import com.beatrice.swcast.presentation.theme.darkGrey30
import com.beatrice.swcast.presentation.theme.gold
import com.beatrice.swcast.resources.Res
import com.beatrice.swcast.resources.ic_back
import org.jetbrains.compose.resources.painterResource

@Composable
fun CharactersListComponent(
    modifier: Modifier = Modifier,
    characters: List<Character>,
    searchQuery: String,
    onQueryChanged: (String) -> Unit,
    navigateToDetailScreen: (Character) -> Unit
) {

    Scaffold(
        modifier = modifier,
        topBar = {
            CharacterListTopBar(
                query = searchQuery,
                onQueryChanged = onQueryChanged
            )
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
                CharacterComponent(character = character,
                    onItemClicked = navigateToDetailScreen)
            }


        }
    }
}

@Composable
fun CharacterListTopBar(modifier: Modifier = Modifier,
                        query: String,
                        onQueryChanged: (String) -> Unit) {
    /**
     * How do I stop searching or hide the search bar
     */
    var isSearching by remember {
        mutableStateOf(false)
    }
    Row(
        modifier = modifier.fillMaxWidth()
            .background(
                color = darkGrey30
            ).padding(start = 12.dp, end = 12.dp, top = 12.dp, bottom = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        if (isSearching) {
            SearchComponent(
                onBackIconClicked = {
                    isSearching = false
                },
                query = query,
                onQueryChanged = onQueryChanged
            )
        }else{
            SmallTitle(title = "Ricky n Morty Cast")

        }
        Icon(
            contentDescription = null,
            imageVector = Icons.Filled.Search,
            tint = gold,
            modifier = Modifier.clickable{
                isSearching = true
            }

        )


    }
}

@Composable
fun SearchComponent(modifier: Modifier = Modifier,
                    onBackIconClicked: () -> Unit,
                    query: String,
                    onQueryChanged: (String) -> Unit) {
    Column(
        modifier = modifier
    ) {
        Icon(
            contentDescription = null,
            painter = painterResource(Res.drawable.ic_back),
            tint = gold,
            modifier = Modifier
                .clickable(onClick = onBackIconClicked)
        )
        Spacer(Modifier.height(16.dp))
        TextInputComponent(
            modifier = Modifier.fillMaxWidth(),
            query = query,
            onQueryChanged = onQueryChanged
        )
    }
}