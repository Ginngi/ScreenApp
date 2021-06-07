package com.gingi.screenapp.second

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.gingi.screenapp.ui.components.Screen

@Composable
fun SecondScreen() {
    Screen(topBarTitle = "Second Screen") { Content() }
}

@Composable
private fun Content() {
    Text(text = "We navigated to Screen Two!")
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    SecondScreen()
}