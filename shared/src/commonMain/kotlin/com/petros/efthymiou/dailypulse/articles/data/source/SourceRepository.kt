package com.petros.efthymiou.dailypulse.articles.data.source

class SourceRepository(
    private val service: SourceService
) {

     suspend fun fetchSource(): List<SourcesRaw> {
        return service.fetchSources()
    }
}