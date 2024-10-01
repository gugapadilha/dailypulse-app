package com.petros.efthymiou.dailypulse.articles

import petros.efthymiou.dailypulse.db.DailyPulseDatabase

class ArticlesDataSource(private val database: DailyPulseDatabase) {

    fun getAllArticles() : List<ArticleRaw> =
        database.dailyPulseDatabaseQueries.selectAllArtitcles(::)

    private fun mapToArticleRaw(
        title: String,
        desc: String?,
        date: String,
        url: String
    ) : ArticleRaw =
        ArticleRaw(
            title,
            desc,
            date,
            url
        )
}