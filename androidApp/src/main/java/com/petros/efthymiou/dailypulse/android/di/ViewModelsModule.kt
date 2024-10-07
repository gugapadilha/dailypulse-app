package com.petros.efthymiou.dailypulse.android.di

import com.petros.efthymiou.dailypulse.articles.presentation.ArticlesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    //using get to simply find a dependency from dependency graph
    viewModel { ArticlesViewModel(get()) }
}