package com.gingi.screenapp.main

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import com.gingi.screenapp.navigation.Destinations
import com.gingi.screenapp.ui.components.Screen

@Composable
fun MainScreen(viewModel: MainViewModel, navController: NavHostController) {
    val state = viewModel.state.collectAsState().value
    val news = viewModel.news.collectAsState(Unit).value

    Screen(topBarTitle = "Main Screen") {
        mainEvents(news = news, navController = navController)
        MainContent(state = state, viewModel = viewModel)
    }
}

private fun mainEvents(news: Any, navController: NavHostController) {
    when (news) {
        is MainNews.NavigateToSecondScreen -> navController.navigate(Destinations.Second.name)
    }
}

@Composable
private fun MainContent(state: MainState, viewModel: MainViewModel) {
    when (state) {
        is MainState.CounterState -> CounterScreen(viewModel, state)
    }
}

@Composable
private fun CounterScreen(viewModel: MainViewModel, state: MainState.CounterState) {
    Column {
        Text(text = state.count.toString())

        Button(onClick = { viewModel.onUserAction(MainActions.IncrementCountClicked) }) {
            Text(text = "Increment")
        }

        Button(onClick = { viewModel.onUserAction(MainActions.NavigationClicked) }) {
            Text(text = "Navigate")
        }
    }
}