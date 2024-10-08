package com.petros.efthymiou.dailypulse.articles.domain

import com.petros.efthymiou.dailypulse.articles.data.ArticleRaw
import com.petros.efthymiou.dailypulse.articles.data.SourceRepository
import com.petros.efthymiou.dailypulse.articles.data.SourcesRaw

class SourceUseCase(private val repo: SourceRepository) {

    suspend fun getSources(): List<Source>{
        val sourcesRaw = repo.fetchSource()
        return mapSources(sourcesRaw)
    }

    private fun mapSources(sourcesRaw: List<SourcesRaw>): List<Source> = sourcesRaw.map { raw ->
        Source(
            raw.id ?: "",
            raw.name?: "",
            raw.desc?: "",
            raw.language?: "en",
            raw.country?: "us"
        )
    }

}