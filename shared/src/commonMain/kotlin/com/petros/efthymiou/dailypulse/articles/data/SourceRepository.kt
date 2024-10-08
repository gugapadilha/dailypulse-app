package com.petros.efthymiou.dailypulse.articles.data

class SourceRepository(
    private val service: SourceService
) {

     suspend fun fetchSource(): List<SourcesRaw> {
        return service.fetchSources()
    }
}