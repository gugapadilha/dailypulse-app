package com.petros.efthymiou.dailypulse.articles.di

import com.petros.efthymiou.dailypulse.articles.data.ArticleService
import com.petros.efthymiou.dailypulse.articles.data.ArticlesDataSource
import com.petros.efthymiou.dailypulse.articles.data.ArticlesRepository
import com.petros.efthymiou.dailypulse.articles.data.SourceRepository
import com.petros.efthymiou.dailypulse.articles.data.SourceService
import com.petros.efthymiou.dailypulse.articles.domain.ArticlesUseCase
import com.petros.efthymiou.dailypulse.articles.domain.SourceUseCase
import com.petros.efthymiou.dailypulse.articles.presentation.ArticlesViewModel
import com.petros.efthymiou.dailypulse.articles.presentation.SourceViewModel
import org.koin.dsl.module

val articleModule = module {

    //simply using get, cause Koin knows we referring ArticlesService and ArticleUseCase instantiation
    single<ArticleService> { ArticleService(get()) }
    single<ArticlesUseCase> { ArticlesUseCase(get()) }
    single<ArticlesViewModel> { ArticlesViewModel(get()) }
    single<ArticlesDataSource> { ArticlesDataSource(get()) }
    single<ArticlesRepository> { ArticlesRepository(get(), get()) }
    single<SourceUseCase> {SourceUseCase(get())}
    single<SourceViewModel> {SourceViewModel(get())}
    single<SourceRepository> { SourceRepository(get()) }
    single<SourceService> {SourceService(get())}
}