package com.petros.efthymiou.dailypulse.articles.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class SourceService(private val httpClient: HttpClient) {

    private val apiKey = "a37830dd20da499ebf4c4251a8b11590"
    private val sources = "sources"


    suspend fun fetchSources(): List<ArticleRaw>{
        val response: ArticlesResponse = httpClient.get("https://newsapi.org/v2/top-headlines?sources=$sources&apiKey=$apiKey").body()
        return response.articles
    }
}