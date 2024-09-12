package com.petros.efthymiou.dailypulse.articles

import com.petros.efthymiou.dailypulse.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel: BaseViewModel() {

    //will be the information between interface and ui - mutable state flow
    private val _articleState: MutableStateFlow<ArticlesState> = MutableStateFlow(ArticlesState())

    //immutable state flow
    val articlesState: StateFlow<ArticlesState> get() = _articleState

    init {
        getArticles()
    }
    private fun getArticles() {
        scope.launch {
            //run any type of asynchronous code without blocking the main thread
            delay(500)
            _articleState.emit(ArticlesState())
        }
    }

    suspend fun fetchArticles(): List<Article> = mockArticles

    private val mockArticles = listOf(
        Article(
            "Stocket market today",
            "foafsj faojif asfiojasfojias aofs fhu a sidjas pfgaos usah dbsuasi",
            "2023-11-09",
            "https://ovicio.com.br/wp-content/uploads/2020/09/20200925-sword-art.jpg"
        ),
        Article(
            "Stocket market today",
            "foafsj faojif asfiojasfojias aofs fhu a sidjas pfgaos usah dbsuasi",
            "2023-11-09",
            "https://ovicio.com.br/wp-content/uploads/2020/09/20200925-sword-art.jpg"
        ),
        Article(
            "Stocket market today",
            "foafsj faojif asfiojasfojias aofs fhu a sidjas pfgaos usah dbsuasi",
            "2023-11-09",
            "https://ovicio.com.br/wp-content/uploads/2020/09/20200925-sword-art.jpg"
        )
    )
}