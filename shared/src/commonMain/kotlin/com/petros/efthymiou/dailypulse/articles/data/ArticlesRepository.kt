package com.petros.efthymiou.dailypulse.articles.data

class ArticlesRepository(
    private val dataSource: ArticlesDataSource,
    private val service: ArticleService
) {

    suspend fun getArticles(forceFetch: Boolean): List<ArticleRaw>{

            fetchArticles()


        val articlesDb = dataSource.getAllArticles()
        println("Got ${articlesDb.size} from the database!")

            return fetchArticles()

    }

    private suspend fun fetchArticles(): List<ArticleRaw> {
        return service.fetchArticles()
    }
}