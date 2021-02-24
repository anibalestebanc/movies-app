package com.imagemaker.presentation

import kotlinx.coroutines.flow.Flow

interface MviView<UserIntent : MviIntent, in ViewState : MviViewState> {
    fun intents(): Flow<UserIntent>
    fun render(viewState: ViewState)
}