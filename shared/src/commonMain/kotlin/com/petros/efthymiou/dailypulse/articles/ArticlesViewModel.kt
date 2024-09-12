package com.petros.efthymiou.dailypulse.articles

import com.petros.efthymiou.dailypulse.BaseViewModel
import kotlinx.coroutines.flow.StateFlow

class ArticlesViewModel: BaseViewModel() {

    val articleState: StateFlow<ArticlesState>
}