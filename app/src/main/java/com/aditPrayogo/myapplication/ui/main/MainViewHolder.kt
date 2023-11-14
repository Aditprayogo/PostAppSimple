package com.aditPrayogo.myapplication.ui.main

import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.aditPrayogo.myapplication.databinding.ItemRowArticleBinding
import com.aditPrayogo.myapplication.ui.detail.DetailActivity
import com.aditprayogo.core.domain.model.Article
import com.aditprayogo.core.utils.DateUtils
import com.aditprayogo.core.utils.formatTo
import com.aditprayogo.core.utils.load
import com.aditprayogo.core.utils.toDate

class MainViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    private val binding = ItemRowArticleBinding.bind(itemView)

    fun bind(data : Article) {
        with(itemView) {
            with(binding) {
                ivArticle.load(data.contentThumbnail)
                txtName.text = data.title
                txtDate.text = data.createdAt.toDate()?.formatTo(dateFormat = DateUtils.DATE_FORMAT_ARTICLE)
            }

            setOnClickListener {
                context.startActivity(
                    Intent(context, DetailActivity::class.java).apply {
                        putExtra(DetailActivity.ARTICLE_DATA, data)
                    }
                )
            }
        }
    }
}