package com.petros.efthymiou.dailypulse.articles.data.source

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class SourceService(private val httpClient: HttpClient) {

    private val apiKey = "a37830dd20da499ebf4c4251a8b11590"

    suspend fun fetchSources(): List<SourcesRaw> {
        val response: SourceResponse = httpClient.get("https://newsapi.org/v2/sources?apiKey=$apiKey").body()
        return response.sources
    }
}