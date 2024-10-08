package com.petros.efthymiou.dailypulse.articles.data.articles

import petros.efthymiou.dailypulse.db.DailyPulseDatabase

class ArticlesDataSource(private val database: DailyPulseDatabase) {

    fun getAllArticles() : List<ArticleRaw> =
        database.dailyPulseDatabaseQueries.selectAllArtitcles(::mapToArticleRaw).executeAsList()

    fun insertArticles(articles : List<ArticleRaw>){
        //only displayed if all the information above are OK, otherwise, will not run(must happen all together)
        database.dailyPulseDatabaseQueries.transaction {
            articles.forEach { articleRaw ->
                insertArticle(articleRaw)
            }
        }
    }

    fun clearArticles() =
        database.dailyPulseDatabaseQueries.removeAllArticles()


    private fun insertArticle(articleRaw: ArticleRaw){
        database.dailyPulseDatabaseQueries.insertArticle(
            articleRaw.title.toString(),
            articleRaw.desc,
            articleRaw.date.toString(),
            articleRaw.imageUrl
        )
    }

    private fun mapToArticleRaw(
        title: String?,
        desc: String?,
        date: String?,
        url: String?
    ) : ArticleRaw =
        ArticleRaw(
            title.toString(),
            desc,
            date.toString(),
            url.toString()
        )
}