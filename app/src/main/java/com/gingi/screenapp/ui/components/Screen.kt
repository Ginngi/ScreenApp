package com.gingi.screenapp.ui.components

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gingi.screenapp.ui.theme.ScreenAppTheme

@Composable
fun Screen(topBarTitle: String, content: @Composable () -> Unit) {
    ScreenAppTheme {
        Scaffold(topBar = { ScreenAppTopBar(topBarTitle) }) {
            content()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    Screen(topBarTitle = "Hello World") {
        Text(text = "Hello World")
    }
}