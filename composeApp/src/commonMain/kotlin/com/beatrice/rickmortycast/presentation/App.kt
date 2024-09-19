package com.beatrice.rickmortycast.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.beatrice.rickmortycast.domain.models.Character
import com.beatrice.rickmortycast.presentation.navigation.RickMortyNavHost
import com.beatrice.rickmortycast.presentation.state.CharacterAction
import com.beatrice.rickmortycast.presentation.state.CharacterUIState
import com.beatrice.rickmortycast.presentation.state.CharacterViewModel
import com.beatrice.rickmortycast.presentation.theme.RickMortyTheme
import org.koin.compose.KoinContext
import org.koin.compose.viewmodel.koinViewModel


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


