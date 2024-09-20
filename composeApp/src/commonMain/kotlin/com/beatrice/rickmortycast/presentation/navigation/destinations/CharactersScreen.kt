package com.beatrice.rickmortycast.presentation.navigation.destinations


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import app.cash.paging.CombinedLoadStates
import app.cash.paging.LoadStateError
import app.cash.paging.LoadStateLoading
import app.cash.paging.compose.collectAsLazyPagingItems
import com.beatrice.rickmortycast.domain.models.Character
import com.beatrice.rickmortycast.presentation.components.CharactersListComponent
import com.beatrice.rickmortycast.presentation.components.ErrorComponent
import com.beatrice.rickmortycast.presentation.state.CharacterAction
import com.beatrice.rickmortycast.presentation.state.CharacterViewModel
import org.koin.compose.viewmodel.koinViewModel
import kotlin.jvm.JvmInline


@Composable
fun CharactersScreen(
    modifier: Modifier = Modifier,
    navigateToDetailScreen: (Character) -> Unit,
    characterViewModel: CharacterViewModel = koinViewModel()
) {
    val isTyping = characterViewModel.isTyping.collectAsStateWithLifecycle().value
    val charactersPagingData = characterViewModel.characters.collectAsLazyPagingItems()
    val pagingState by remember {
        derivedStateOf {
            if (!isTyping) {
                charactersPagingData.loadState.getState()
            } else {
                CharacterPagingState.Loading
            }
        }
    }


    AnimatedVisibility(visible = !isTyping,
        enter = slideInHorizontally(
            animationSpec = tween(1000)
        ) + fadeIn()
    ) {
        CharactersListComponent(
            modifier = modifier,
            characters = charactersPagingData,
            searchQuery = "",
            onQueryChanged = {
                // Coming soon
            },
            navigateToDetailScreen = navigateToDetailScreen
        )
    }
    when (pagingState) {
        is CharacterPagingState.Default -> {
            // Do nothing
        }

        is CharacterPagingState.Error -> {
            ErrorComponent(
                message = (pagingState as CharacterPagingState.Error).message,
                onRetry = {

                }
            )
        }

        is CharacterPagingState.ErrorWithData -> {
            Box(modifier = modifier.fillMaxHeight()) {
                Text(
                    text = (pagingState as CharacterPagingState.ErrorWithData).message,
                    style = TextStyle(
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp,
                        fontFamily = FontFamily.Serif,
                        color = Color.Red,
                        fontWeight = FontWeight.SemiBold
                    ),
                    modifier = Modifier.align(alignment = Alignment.BottomCenter)
                )
            }
        }

        is CharacterPagingState.Loading -> {
            if (isTyping) {
                LoadingScreen(modifier = modifier.fillMaxSize(),
                    onFinishTyping = {
                        characterViewModel.sendEvent(CharacterAction.FinishTyping)
                    })
            }

        }

        is CharacterPagingState.LoadingMoreCharacters -> {
            // Do Nothing
        }
    }


}

sealed interface CharacterPagingState {
    data object Default : CharacterPagingState
    data object Loading : CharacterPagingState
    data object LoadingMoreCharacters : CharacterPagingState
    @JvmInline
    value class Error(val message: String) : CharacterPagingState
    @JvmInline
    value class ErrorWithData(val message: String) : CharacterPagingState
}

fun CombinedLoadStates.getState(): CharacterPagingState {
    val loadState = this
    var state: CharacterPagingState = CharacterPagingState.Default
    if (loadState.refresh == LoadStateLoading) {
        state = CharacterPagingState.Loading
    }
    if (loadState.append == LoadStateLoading) {
        state = CharacterPagingState.LoadingMoreCharacters
    }

    if (loadState.refresh is LoadStateError || loadState.append is LoadStateError) {
        val isPaginatingError = (loadState.append is LoadStateError)
        val error = if (loadState.append is LoadStateError) {
            (loadState.append as LoadStateError).error
        } else {
            (loadState.refresh as LoadStateError).error
        }

        if (isPaginatingError) {
            state = CharacterPagingState.ErrorWithData(
                message = error.message ?: "Something Went Wrong"
            )
        } else {
            state = CharacterPagingState.Error(message = error.message ?: "Something Went Wrong")
        }
    }
    return state
}