package com.petros.efthymiou.dailypulse.articles

class ArticlesRepository(
    private val dataSource: ArticlesDataSource,
    private val service: ArticleService
) {

    suspend fun getArticles(): List<ArticleRaw>{
        val articlesDb = dataSource.getAllArticles()
        println("Got ${articlesDb.size} from the database!")

        if (articlesDb.isNotEmpty()){
            val fetchedArticles = service.fetchArticles()
            dataSource.insertArticles(fetchedArticles)
            return fetchedArticles
        }
        return articlesDb
    }
}