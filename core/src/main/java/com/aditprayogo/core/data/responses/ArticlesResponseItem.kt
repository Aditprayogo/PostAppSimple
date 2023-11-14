package com.aditprayogo.core.data.responses

data class ArticlesResponseItem(
    val content: String,
    val contentThumbnail: String,
    val contributorAvatar: String,
    val contributorName: String,
    val createdAt: String,
    val id: String,
    val slideshow: List<String>,
    val title: String
)