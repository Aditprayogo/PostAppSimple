package com.aditprayogo.core.utils

import com.aditprayogo.core.data.responses.ArticlesResponseItem
import com.aditprayogo.core.domain.model.Article

object DataMapper {

    /**
     * Map data from data layer to domain layer.
     */
    fun mapArticleResponseItemToDataDomain(data : List<ArticlesResponseItem>) : List<Article> {
        return data.map {
            Article(
                content = it.content,
                contentThumbnail = it.contentThumbnail,
                contributorAvatar = it.contributorAvatar,
                contributorName = it.contributorName,
                createdAt = it.createdAt,
                id = it.id,
                slideshow = it.slideshow,
                title = it.title
            )
        }
    }
}