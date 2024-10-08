package com.petros.efthymiou.dailypulse.articles.presentation

import com.petros.efthymiou.dailypulse.BaseViewModel
import com.petros.efthymiou.dailypulse.articles.domain.SourceUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SourceViewModel(private val useCase: SourceUseCase) : BaseViewModel() {

    private val _sourceState: MutableStateFlow<SourceState> = MutableStateFlow(SourceState())

    val sourcesState: StateFlow<SourceState> get() = _sourceState

    init {
        getSources()
    }
    fun getSources() {
        scope.launch {

            _sourceState.emit(SourceState(sources = _sourceState.value.sources))

            //run any type of asynchronous code without blocking the main thread
            val fetched = useCase.getSources()

            _sourceState.emit(SourceState())
        }
    }


}