package com.aditprayogo.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Article(
    val content: String,
    val contentThumbnail: String,
    val contributorAvatar: String,
    val contributorName: String,
    val createdAt: String,
    val id: String,
    val slideshow: List<String>,
    val title: String
) : Parcelable