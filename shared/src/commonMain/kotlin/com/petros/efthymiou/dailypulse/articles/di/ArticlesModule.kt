package com.petros.efthymiou.dailypulse.articles.di

import com.petros.efthymiou.dailypulse.articles.Article
import com.petros.efthymiou.dailypulse.articles.ArticleService
import com.petros.efthymiou.dailypulse.articles.ArticlesUseCase
import com.petros.efthymiou.dailypulse.articles.ArticlesViewModel
import org.koin.dsl.module

val articleModule = module {

    //simply using get, cause Koin knows we referring ArticlesService and ArticleUseCase instantiation
    single<ArticleService> { ArticleService(get()) }
    single<ArticlesUseCase> { ArticlesUseCase(get()) }
    single<ArticlesViewModel> { ArticlesViewModel()}
}