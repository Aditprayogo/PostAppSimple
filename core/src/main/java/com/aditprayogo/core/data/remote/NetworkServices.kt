package com.aditprayogo.core.data.remote

import com.aditprayogo.core.data.responses.ArticlesResponse
import retrofit2.http.GET

interface NetworkServices {

    /**
     * Endpoints Get Articles
     */
    @GET("articles")
    suspend fun getArticles() : ArticlesResponse

}