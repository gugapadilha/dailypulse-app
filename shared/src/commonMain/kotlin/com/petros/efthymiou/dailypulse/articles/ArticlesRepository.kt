package com.petros.efthymiou.dailypulse.articles

class ArticlesRepository(
    private val dataSource: ArticlesDataSource,
    private val service: ArticleService
) {

    suspend fun getArticles(forceFetch: Boolean): List<ArticleRaw>{

        if (forceFetch){
            dataSource.clearArticles()
            fetchArticles()
        }

        val articlesDb = dataSource.getAllArticles()
        println("Got ${articlesDb.size} from the database!")

        if (articlesDb.isNotEmpty()){
            return fetchArticles()
        }
        return articlesDb
    }

    private suspend fun fetchArticles(): List<ArticleRaw> {
        val fetchedArticles = service.fetchArticles()
        dataSource.insertArticles(fetchedArticles)
        return fetchedArticles
    }
}