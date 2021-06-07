package com.gingi.screenapp.main

internal sealed class MainState {
    data class CounterState(val count: Int): MainState()
}