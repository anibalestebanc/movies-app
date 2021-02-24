package com.imagemaker.presentation

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

@ExperimentalCoroutinesApi
interface MviViewModel<UserIntent : MviIntent, ViewState : MviViewState> {
    fun processIntents(userIntents: Flow<UserIntent>)
    fun states(): StateFlow<ViewState>
}