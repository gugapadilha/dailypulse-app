package com.petros.efthymiou.dailypulse.android.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.petros.efthymiou.dailypulse.articles.domain.Source
import com.petros.efthymiou.dailypulse.articles.presentation.SourceViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun SourceScreen(
    onUpButtonClick: () -> Unit,
    viewModel: SourceViewModel = getViewModel()
) {

    Column {
        Toolbar(onUpButtonClick)
        SourceListView(viewModel = viewModel )
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

@Composable
fun SourceListView(viewModel: SourceViewModel) {
    LaunchedEffect(Unit) {
        viewModel.getSources()
    }

    val sourceState = viewModel.sourcesState.value

    if (sourceState.sources.isNotEmpty()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(sourceState.sources) { source ->
                SourceItemView(source = source)
            }
        }
    } else if (sourceState.loading) {
        LoadingView()
    } else if (sourceState.error != null) {
        ErrorMessage(sourceState.error!!)
    }
}

@Composable
fun LoadingView() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Loading...", style = TextStyle(fontSize = 22.sp))
    }
}

@Composable
fun SourceItemView(source: Source) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = source.name.toString(),
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 22.sp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = source.desc.toString())
        Spacer(modifier = Modifier.height(4.dp))

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = source.country + " - " + source.language,
                style = TextStyle(color = Color.Gray),
                modifier = Modifier.align(Alignment.End)
            )
            Spacer(modifier = Modifier.height(4.dp))
        }

    }
}

