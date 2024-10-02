package com.petros.efthymiou.dailypulse.articles

class ArticlesRepository(
    private val dataSource: ArticlesDataSource,
    private val service: ArticleService
) {
}