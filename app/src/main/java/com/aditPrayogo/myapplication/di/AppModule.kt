package com.aditPrayogo.myapplication.di

import com.aditprayogo.core.domain.usecase.ArticleUseCase
import com.aditprayogo.core.domain.usecase.ArticleUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    abstract fun provideArticleUseCase(articleUseCaseImpl: ArticleUseCaseImpl) : ArticleUseCase
}