package com.petros.efthymiou.dailypulse.articles.presentation.articles

import com.petros.efthymiou.dailypulse.BaseViewModel
import com.petros.efthymiou.dailypulse.articles.domain.articles.ArticlesUseCase
import com.petros.efthymiou.dailypulse.articles.presentation.articles.ArticlesState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

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