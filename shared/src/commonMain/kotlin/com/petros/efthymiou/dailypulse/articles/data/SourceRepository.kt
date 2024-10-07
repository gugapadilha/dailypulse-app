package com.petros.efthymiou.dailypulse.articles.data

class SourceRepository(
    private val service: SourceService
) {

    private suspend fun fetchSource(): List<ArticleRaw> {
        return service.fetchSources()
    }
}