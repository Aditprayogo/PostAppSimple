package com.aditprayogo.core.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory

fun ImageView.load(imageSearch: Any) {
    Glide.with(context.applicationContext)
        .load(imageSearch)
        .transition(DrawableTransitionOptions.withCrossFade(getDrawableFactory()))
        .into(this)
}

private fun getDrawableFactory() : DrawableCrossFadeFactory {
    return DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build()
}

object DateUtils {
    const val DATE_FORMAT_ARTICLE = "dd MMM yyyy, HH:mm"
}