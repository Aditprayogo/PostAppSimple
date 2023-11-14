package com.aditprayogo.core.domain.usecase

import com.aditprayogo.core.domain.model.Article
import com.aditprayogo.core.domain.repository.ArticleRepository
import com.aditprayogo.core.utils.state.ResultState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ArticleUseCaseImpl @Inject constructor(private val articleRepository: ArticleRepository) : ArticleUseCase {
    override suspend fun getArticles(): Flow<ResultState<List<Article>>> = articleRepository.getArticles()
}