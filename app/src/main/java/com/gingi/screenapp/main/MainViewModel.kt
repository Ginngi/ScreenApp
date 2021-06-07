package com.gingi.screenapp.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    private val _news = MutableSharedFlow<MainNews>()
    internal val news: SharedFlow<MainNews> = _news

    private val _state = MutableStateFlow<MainState>(MainState.CounterState(0))
    internal val state: StateFlow<MainState> = _state

    fun onUserAction(actions: MainActions) {
        when (actions) {
            MainActions.IncrementCountClicked -> updateCounter()
            MainActions.NavigationClicked -> viewModelScope.launch {
                _news.emit(MainNews.NavigateToSecondScreen)
            }
        }
    }

    private fun updateCounter() {
        val currentState = state.value

        viewModelScope.launch {
            _state.emit(
                if (currentState is MainState.CounterState) {
                    MainState.CounterState(count = currentState.count + 1)
                } else {
                    MainState.CounterState(0)
                }
            )
        }
    }
}