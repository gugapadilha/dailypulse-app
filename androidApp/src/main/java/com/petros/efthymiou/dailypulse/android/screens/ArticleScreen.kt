package com.petros.efthymiou.dailypulse.android.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.petros.efthymiou.dailypulse.articles.Article
import com.petros.efthymiou.dailypulse.articles.ArticlesViewModel

@Composable
fun ArticleScreen(
    articlesViewModel: ArticlesViewModel
) {
    val articleState = articlesViewModel

    Column {
        AppBar()

    }

}

@Composable
fun ArticleListView(articles: List<Article>) {

    LazyColumn(modifier = Modifier.fillMaxSize()){
        items(articles){article ->
            ArticleItemView(article = article)
        }
    }

}