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

class ArticlesViewModel(private val useCase: ArticlesUseCase): BaseViewModel() {

    //will be the information between interface and ui - mutable state flow
    private val _articleState: MutableStateFlow<ArticlesState> = MutableStateFlow(ArticlesState(loading = true))

    //immutable state flow
    val articlesState: StateFlow<ArticlesState> get() = _articleState

    init {
        getArticles()
    }
     fun getArticles(forceFetch: Boolean = false) {
        scope.launch {

            _articleState.emit(ArticlesState(loading = true, articles = _articleState.value.articles))

            //run any type of asynchronous code without blocking the main thread
            val fetched = useCase.getArticles(forceFetch)

            _articleState.emit(ArticlesState(articles = fetched))
        }
    }

}