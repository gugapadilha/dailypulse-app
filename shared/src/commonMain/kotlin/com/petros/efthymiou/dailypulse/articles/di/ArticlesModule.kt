package com.petros.efthymiou.dailypulse.articles.di

import com.petros.efthymiou.dailypulse.articles.data.articles.ArticleService
import com.petros.efthymiou.dailypulse.articles.data.articles.ArticlesDataSource
import com.petros.efthymiou.dailypulse.articles.data.articles.ArticlesRepository
import com.petros.efthymiou.dailypulse.articles.data.source.SourceRepository
import com.petros.efthymiou.dailypulse.articles.data.source.SourceService
import com.petros.efthymiou.dailypulse.articles.domain.articles.ArticlesUseCase
import com.petros.efthymiou.dailypulse.articles.domain.source.SourceUseCase
import com.petros.efthymiou.dailypulse.articles.presentation.articles.ArticlesViewModel
import com.petros.efthymiou.dailypulse.articles.presentation.source.SourceViewModel
import org.koin.dsl.module

val articleModule = module {

    //simply using get, cause Koin knows we referring ArticlesService and ArticleUseCase instantiation
    single<ArticleService> { ArticleService(get()) }
    single<ArticlesUseCase> { ArticlesUseCase(get()) }
    single<ArticlesViewModel> { ArticlesViewModel(get()) }
    single<ArticlesDataSource> { ArticlesDataSource(get()) }
    single<ArticlesRepository> { ArticlesRepository(get(), get()) }
    single<SourceUseCase> { SourceUseCase(get()) }
    single<SourceViewModel> { SourceViewModel(get()) }
    single<SourceRepository> { SourceRepository(get()) }
    single<SourceService> { SourceService(get()) }
}