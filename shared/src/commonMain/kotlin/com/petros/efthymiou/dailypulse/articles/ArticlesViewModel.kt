package com.petros.efthymiou.dailypulse.articles

import com.petros.efthymiou.dailypulse.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ArticlesViewModel: BaseViewModel() {

    //will be the information between interface and ui - mutable state flow
    private val _articleState: MutableStateFlow<ArticlesState> = MutableStateFlow(ArticlesState())

    //immutable state flow
    val articlesState: StateFlow<ArticlesState> get() = _articleState
}