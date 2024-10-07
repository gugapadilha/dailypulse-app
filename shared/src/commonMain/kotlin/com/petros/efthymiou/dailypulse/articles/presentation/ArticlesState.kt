package com.petros.efthymiou.dailypulse.articles.presentation

import com.petros.efthymiou.dailypulse.articles.domain.Article

data class ArticlesState(
    val articles: List<Article> = listOf(),
    val loading: Boolean = false,
    val error: String? = null
)
