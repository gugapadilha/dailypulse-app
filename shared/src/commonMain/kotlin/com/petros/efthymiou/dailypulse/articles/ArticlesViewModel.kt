package com.petros.efthymiou.dailypulse.articles

import com.petros.efthymiou.dailypulse.BaseViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

class ArticlesViewModel: BaseViewModel() {

    //will be the information between interface and ui - mutable state flow
    private val _articleState: MutableStateFlow<ArticlesState> = MutableStateFlow(ArticlesState(loading = true))

    //immutable state flow
    val articlesState: StateFlow<ArticlesState> get() = _articleState

    val useCase: ArticlesUseCase

    init {
        val httpClient = HttpClient{
            install(ContentNegotiation){
                json(Json{
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                    })
            }
        }
        getArticles()
    }
    private fun getArticles() {
        scope.launch {

            //run any type of asynchronous code without blocking the main thread
            val fetched = useCase.getArticles()

            _articleState.emit(ArticlesState(articles = fetched))
        }
    }

}