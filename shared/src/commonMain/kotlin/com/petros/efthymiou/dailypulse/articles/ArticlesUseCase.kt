package com.petros.efthymiou.dailypulse.articles

class ArticlesUseCase(private val service: ArticleService) {

    suspend fun getArticles(): List<Article>{
        val articlesRaw = service.fetchArticles()
        return mapArticles(articlesRaw)
    }

    private fun mapArticles(articlesRaw: List<ArticleRaw>): List<Article> = articlesRaw.map { raw ->
        Article(
            raw.title,
            raw.desc ?: "Click to find out more",
            raw.date,
            raw.imageUrl?: ""
        )
    }
}