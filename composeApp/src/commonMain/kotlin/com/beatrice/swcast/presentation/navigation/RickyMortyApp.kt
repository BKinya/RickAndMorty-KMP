package com.beatrice.swcast.presentation.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.beatrice.swcast.domain.models.Character
import com.beatrice.swcast.presentation.navigation.destinations.CharacterDetailScreen
import com.beatrice.swcast.presentation.navigation.destinations.CharactersScreen
import com.beatrice.swcast.presentation.state.CharacterUIState
import kotlinx.serialization.json.Json

@Composable
fun RickyMortyApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    characterUIState: CharacterUIState
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = RickyMortyScreen.CharacterScreen.route
    ) {
        composable(
            RickyMortyScreen.CharacterScreen.route,
        ) {
            CharactersScreen(characterUIState = characterUIState,
                navigateToDetailScreen = { character ->
                    val route = RickyMortyScreen.CharacterDetailScreen.createRoute(character)
                    navController.navigate(route) {

                    }

                })
        }

        composable(
            RickyMortyScreen.CharacterDetailScreen.route,
            enterTransition = { fadeIn(
                animationSpec = tween(300, easing = LinearEasing)
            ) + slideIntoContainer(
                animationSpec = tween(300, easing = EaseIn),
                towards = AnimatedContentTransitionScope.SlideDirection.Start
            ) },
            exitTransition = {
                fadeOut(
                    animationSpec = tween(300, easing = LinearEasing)
                ) + slideOutOfContainer(
                    animationSpec = tween(300, easing = EaseOut),
                    towards = AnimatedContentTransitionScope.SlideDirection.End
                )
            },
            popExitTransition = { fadeOut(
                animationSpec = tween(300, easing = LinearEasing)
            ) + slideOutOfContainer(
                animationSpec = tween(300, easing = EaseOut),
                towards = AnimatedContentTransitionScope.SlideDirection.End
            ) },
        ) { backStackEntry ->
            val characterJson = backStackEntry.arguments?.getString("character")
            requireNotNull(characterJson) { "Oops! Character not found" }
            val character = Json.decodeFromString<Character>(characterJson)

            CharacterDetailScreen(
                character = character,
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }

    }
}