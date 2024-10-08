package com.beatrice.rickmortycast.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.cash.paging.compose.LazyPagingItems
import com.beatrice.rickmortycast.domain.models.Character
import com.beatrice.rickmortycast.presentation.theme.darkGrey30
import com.beatrice.rickmortycast.presentation.theme.gold
import com.beatrice.rickmortycast.resources.Res
import com.beatrice.rickmortycast.resources.ic_back
import org.jetbrains.compose.resources.painterResource

@Composable
fun CharactersListComponent(
    modifier: Modifier = Modifier,
    characters: LazyPagingItems<Character>,
    searchQuery: String,
    onQueryChanged: (String) -> Unit,
    navigateToDetailScreen: (Character) -> Unit
) {

    Scaffold(
        modifier = modifier,
        topBar = {
            if (characters.itemCount > 0) {
                CharacterListTopBar(
                    query = searchQuery,
                    onQueryChanged = onQueryChanged
                )
            }
        }
    ) { contentPadding ->
        LazyVerticalGrid(
            modifier = modifier.padding(8.dp),
            contentPadding = contentPadding,
            columns = GridCells.Adaptive(minSize = 144.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(
                characters.itemCount,
            ) { index ->
                val character = characters[index]
                character?.let {
                    CharacterComponent(
                        character = it,
                        onItemClicked = navigateToDetailScreen
                    )
                }

            }
        }
    }
}

@Composable
fun CharacterListTopBar(
    modifier: Modifier = Modifier,
    query: String,
    onQueryChanged: (String) -> Unit
) {
    var isSearching by remember {
        mutableStateOf(false)
    }
    Row(
        modifier = modifier.fillMaxWidth()
            .background(
                color = darkGrey30
            ).padding(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        SmallTitle(title = "Ricky n Morty Cast",
            modifier = Modifier.padding(12.dp))
// TODO: Implement searching later
//        if (isSearching) {
//            Box(modifier = Modifier.fillMaxWidth().background(color = MaterialTheme.colorScheme.surface)) {
//                SearchComponent(
//                    onBackIconClicked = {
//                        isSearching = false
//                    },
//                    query = query,
//                    onQueryChanged = onQueryChanged
//                )
//            }
//        } else {
//            SmallTitle(title = "Ricky n Morty Cast",
//                modifier = Modifier.padding(12.dp))
//
//        }
//        Icon(
//            contentDescription = null,
//            imageVector = Icons.Filled.Search,
//            tint = gold,
//            modifier = Modifier
//                .padding(12.dp).clickable {
//                isSearching = true
//            }
//
//        )


    }
}

@Composable
fun SearchComponent(
    modifier: Modifier = Modifier,
    onBackIconClicked: () -> Unit,
    query: String,
    onQueryChanged: (String) -> Unit
) {
    Column(
        modifier = modifier.padding(start = 12.dp, end = 12.dp, bottom = 12.dp )
    ) {
        Icon(
            contentDescription = null,
            painter = painterResource(Res.drawable.ic_back),
            tint = gold,
            modifier = Modifier
                .padding(top = 16.dp)
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