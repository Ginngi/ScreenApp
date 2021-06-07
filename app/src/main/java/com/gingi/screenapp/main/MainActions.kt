package com.gingi.screenapp.main

sealed class MainActions {
    object NavigationClicked : MainActions()
    object IncrementCountClicked : MainActions()
}