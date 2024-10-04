package com.beatrice.rickmortycast.presentation.state

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.beatrice.rickmortycast.domain.models.Character
import com.beatrice.rickmortycast.domain.repository.CharacterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class CharacterViewModel(
    private val repository: CharacterRepository
) : ViewModel() {
    private val _characters: MutableStateFlow<PagingData<Character>> =
        MutableStateFlow(PagingData.empty())
    val characters: StateFlow<PagingData<Character>> = _characters.onStart {
        sendEvent(CharacterAction.FetchAllCharacters)
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000L),
        PagingData.empty()
    )

    private val _episodesUiState = MutableStateFlow<UiState> (UiState.Default)
    val episodesUiState: StateFlow<UiState> = _episodesUiState

    private val _isTyping: MutableStateFlow<Boolean> = MutableStateFlow(true)
    val isTyping: StateFlow<Boolean> = _isTyping.asStateFlow()

    val eventStream = MutableSharedFlow<CharacterAction>(extraBufferCapacity = 10)

    init {
        handleCharacterActions()
    }

   private fun handleCharacterActions() {
        viewModelScope.launch {
            eventStream.collect { event ->
                when (event) {
                    is CharacterAction.FetchAllCharacters -> onFetchCharacters()
                    is CharacterAction.FinishTyping -> onFinishTyping()
                    is CharacterAction.FetchCharacterEpisodes ->onFetchCharacterEpisodes(event.episodeUrls)
                }

            }
        }
    }

     fun sendEvent(action: CharacterAction) {
        viewModelScope.launch {
            eventStream.emit(action)
        }

    }

    private fun onFinishTyping() {
        viewModelScope.launch {
            delay(500)
            _isTyping.value = false
        }
    }


    private fun onFetchCharacters() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllCharacters()
                .cachedIn(this)
                .collect { response ->
                    _characters.value = response
                }
        }
    }

    private fun onFetchCharacterEpisodes(episodesUrls: List<String>){
        viewModelScope.launch(Dispatchers.IO) {
            repository.getCharacterEpisodes(episodesUrls)
                .onStart {
                    _episodesUiState.value = UiState.Loading
                }
                .collect{ episodes ->
                    if (episodes.isEmpty()){
                        _episodesUiState.value = UiState.Empty(message = "No episodes found")
                    }else{
                        _episodesUiState.value = UiState.Content(data = episodes)
                    }
            }
        }
    }
}