package com.aditprayogo.core.data

import android.util.Log
import com.aditprayogo.core.data.remote.NetworkServices
import com.aditprayogo.core.domain.model.Article
import com.aditprayogo.core.domain.repository.ArticleRepository
import com.aditprayogo.core.utils.DataMapper
import com.aditprayogo.core.utils.state.ResultState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ArticleRepositoryImpl @Inject constructor(
    private val networkServices: NetworkServices
) : ArticleRepository {

    override suspend fun getArticles(): Flow<ResultState<List<Article>>> {
        return flow {
            try {
                val response = networkServices.getArticles()
                val mappedData = DataMapper.mapArticleResponseItemToDataDomain(response)
                emit(ResultState.Success(mappedData))
            } catch (e : Exception) {
                emit(ResultState.Error(e.toString(), 500))
            }
        }.flowOn(Dispatchers.IO)
    }
}