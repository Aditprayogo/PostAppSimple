package com.aditprayogo.core.domain.usecase

import com.aditprayogo.core.domain.model.Article
import com.aditprayogo.core.utils.state.ResultState
import kotlinx.coroutines.flow.Flow

interface ArticleUseCase {
    suspend fun getArticles() : Flow<ResultState<List<Article>>>
}