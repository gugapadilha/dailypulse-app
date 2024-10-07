package com.petros.efthymiou.dailypulse.articles.di

import com.petros.efthymiou.dailypulse.articles.data.ArticleService
import com.petros.efthymiou.dailypulse.articles.data.ArticlesDataSource
import com.petros.efthymiou.dailypulse.articles.data.ArticlesRepository
import com.petros.efthymiou.dailypulse.articles.domain.ArticlesUseCase
import com.petros.efthymiou.dailypulse.articles.presentation.ArticlesViewModel
import org.koin.dsl.module

val articleModule = module {

    //simply using get, cause Koin knows we referring ArticlesService and ArticleUseCase instantiation
    single<ArticleService> { ArticleService(get()) }
    single<ArticlesUseCase> { ArticlesUseCase(get()) }
    single<ArticlesViewModel> { ArticlesViewModel(get()) }
    single<ArticlesDataSource> { ArticlesDataSource(get()) }
    single<ArticlesRepository> { ArticlesRepository(get(), get()) }
}