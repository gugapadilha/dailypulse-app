package com.petros.efthymiou.dailypulse.articles.data

class SourceRepository(
    private val service: ArticleService
) {

    private suspend fun fetchSource(): List<ArticleRaw> {
        return service.fetchArticles()
    }
}