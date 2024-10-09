package com.petros.efthymiou.dailypulse.articles.presentation.source

import com.petros.efthymiou.dailypulse.BaseViewModel
import com.petros.efthymiou.dailypulse.articles.domain.source.SourceUseCase
import com.petros.efthymiou.dailypulse.articles.presentation.source.SourceState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SourceViewModel(private val useCase: SourceUseCase) : BaseViewModel() {

    private val _sourceState: MutableStateFlow<SourceState> = MutableStateFlow(SourceState(loading = true))

    val sourcesState: StateFlow<SourceState> get() = _sourceState

    init {
        getSources()
    }
    fun getSources() {
        scope.launch {

            _sourceState.emit(SourceState(loading = true, sources = _sourceState.value.sources))

            //run any type of asynchronous code without blocking the main thread
            val fetched = useCase.getSources()

            _sourceState.emit(SourceState(sources = fetched))
        }
    }


}