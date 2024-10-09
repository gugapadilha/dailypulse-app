package com.petros.efthymiou.dailypulse.articles.data.articles

import com.petros.efthymiou.dailypulse.articles.data.articles.ArticleRaw
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArticlesResponse(
    @SerialName("status")
    val status: String,
    @SerialName("totalResults")
    val results: Int,
    @SerialName("articles")
    val articles: List<ArticleRaw>
)