package com.beatrice.swcast.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.beatrice.swcast.presentation.components.BigTitle
import com.beatrice.swcast.presentation.components.SearchComponent

@Composable
fun StartScreen(modifier: Modifier = Modifier) {
    var query by remember {
        mutableStateOf("")
    }
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BigTitle(
            title = "Ricky and Morty Cast",
            modifier = Modifier.padding(32.dp)
        )
        Spacer(Modifier.height(64.dp))

        SearchComponent(
            modifier = Modifier.fillMaxWidth().padding(20.dp),
            query = query,
            onQueryChanged = {
                println("Text is $it")
                query = it
            }
        )
    }
}