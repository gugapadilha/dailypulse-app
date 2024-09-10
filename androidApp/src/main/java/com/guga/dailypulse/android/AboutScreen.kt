package com.guga.dailypulse.android

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable


@Composable
fun AboutScreen(){
    Column {
        Toolbar()
        ContentView()
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Toolbar() {
    TopAppBar(
        title = {
        Text(text = "About Device")
    })
}