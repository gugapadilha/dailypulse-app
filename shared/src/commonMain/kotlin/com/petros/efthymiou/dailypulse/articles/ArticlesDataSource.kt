package com.petros.efthymiou.dailypulse.articles

import petros.efthymiou.dailypulse.db.DailyPulseDatabase

class ArticlesDataSource(private val database: DailyPulseDatabase) {

    fun getAllArticles() : List<ArticleRaw> =
        database.dailyPulseDatabaseQueries
}