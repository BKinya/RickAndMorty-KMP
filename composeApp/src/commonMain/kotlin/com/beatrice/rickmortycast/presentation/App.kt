package com.beatrice.rickmortycast.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.beatrice.rickmortycast.presentation.navigation.RickMortyNavHost
import com.beatrice.rickmortycast.presentation.theme.RickMortyTheme
import org.koin.compose.KoinContext


@Composable
fun App(modifier: Modifier = Modifier) {

    RickMortyTheme {
        KoinContext {
            Scaffold(modifier = modifier.fillMaxSize()) {
                RickMortyNavHost()
            }
        }
    }

}


