package com.petros.efthymiou.dailypulse.articles.presentation

import com.petros.efthymiou.dailypulse.articles.domain.SourceUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SourceViewModel(private val useCase: SourceUseCase) {

    private val _sourceState: MutableStateFlow<SourceState> = MutableStateFlow(SourceState())

    val sourcesState: StateFlow<SourceState> get() = _sourceState

}