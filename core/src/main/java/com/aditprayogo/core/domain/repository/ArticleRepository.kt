package com.aditprayogo.core.domain.repository

import com.aditprayogo.core.domain.model.Article
import com.aditprayogo.core.utils.state.ResultState
import kotlinx.coroutines.flow.Flow

interface ArticleRepository {
    suspend fun getArticles() : Flow<ResultState<List<Article>>>
}