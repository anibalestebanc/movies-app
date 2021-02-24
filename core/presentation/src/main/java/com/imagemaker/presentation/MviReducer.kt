package com.imagemaker.presentation

interface MviReducer<ViewState : MviViewState, Result : MviResult> {
    infix fun ViewState.reduce(result: Result): ViewState
}