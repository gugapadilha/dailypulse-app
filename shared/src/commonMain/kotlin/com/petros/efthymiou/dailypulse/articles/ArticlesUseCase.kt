package com.petros.efthymiou.dailypulse.articles

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.daysUntil
import kotlinx.datetime.toLocalDateTime
import kotlinx.datetime.todayIn
import kotlin.math.abs

class ArticlesUseCase(private val service: ArticleService) {

    suspend fun getArticles(): List<Article>{
        val articlesRaw = service.fetchArticles()
        return mapArticles(articlesRaw)
    }

    private fun mapArticles(articlesRaw: List<ArticleRaw>): List<Article> = articlesRaw.map { raw ->
        Article(
            raw.title ?: "",
            raw.desc ?: "Click to find out more",
            getDaysAgoString(raw.date),
            raw.imageUrl?: "https://ovicio.com.br/wp-content/uploads/2020/09/20200925-sword-art.jpg"
        )
    }

    private fun getDaysAgoString(date: String): String {
        val today = Clock.System.todayIn(kotlinx.datetime.TimeZone.currentSystemDefault())
        val days = today.daysUntil(
            Instant.parse(date).toLocalDateTime(kotlinx.datetime.TimeZone.currentSystemDefault()).date
        )

        val result = when {
            abs(days) > 1 -> "${abs(days)} days ago"
            abs(days) == 1 -> "Yesterday"
            else -> "Today"
        }

        return result
    }
}