package com.petros.efthymiou.dailypulse.articles

import com.petros.efthymiou.dailypulse.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel: BaseViewModel() {

    //will be the information between interface and ui - mutable state flow
    private val _articleState: MutableStateFlow<ArticlesState> = MutableStateFlow(ArticlesState(loading = true))

    //immutable state flow
    val articlesState: StateFlow<ArticlesState> get() = _articleState

    init {
        getArticles()
    }
    private fun getArticles() {
        scope.launch {
            delay(1500)

            _articleState.emit(ArticlesState(error = "Something went wrong"))

            delay(1500)


            //run any type of asynchronous code without blocking the main thread
            val fetched = fetchArticles()


            _articleState.emit(ArticlesState(articles = fetched))
        }
    }

}