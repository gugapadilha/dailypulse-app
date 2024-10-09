package com.petros.efthymiou.dailypulse.articles.presentation.source

import com.petros.efthymiou.dailypulse.articles.domain.source.Source

data class SourceState(
    val sources: List<Source> = listOf(),
    val loading: Boolean = false,
    val error: String? = null
)