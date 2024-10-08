package com.petros.efthymiou.dailypulse.android.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable

@Composable
fun SourceScreen(
    onUpButtonClick: () -> Unit
) {

    Column {
        Toolbar(onUpButtonClick)
    }
}

@Composable
private fun Toolbar(
    onUpButtonClick: () -> Unit
) {
    IconButton(onClick = onUpButtonClick) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Up Button",
        )
    }
}


