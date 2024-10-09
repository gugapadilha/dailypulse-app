package com.petros.efthymiou.dailypulse.articles.presentation.articles

import com.petros.efthymiou.dailypulse.articles.domain.articles.Article

data class ArticlesState(
    val articles: List<Article> = listOf(),
    val loading: Boolean = false,
    val error: String? = null
)
