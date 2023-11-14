package com.aditPrayogo.myapplication.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aditPrayogo.myapplication.R
import com.aditPrayogo.myapplication.databinding.ActivityDetailBinding
import com.aditprayogo.core.domain.model.Article
import com.aditprayogo.core.utils.DateUtils.DATE_FORMAT_ARTICLE
import com.aditprayogo.core.utils.formatTo
import com.aditprayogo.core.utils.load
import com.aditprayogo.core.utils.toDate

class DetailActivity : AppCompatActivity() {

    private val binding: ActivityDetailBinding by lazy {
        ActivityDetailBinding.inflate(layoutInflater)
    }

    private var data: Article? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        handleIntentData()
    }

    private fun handleIntentData() {
        data = intent.getParcelableExtra(ARTICLE_DATA)

        with(binding) {
            data?.let { ivArticleDetail.load(it.contentThumbnail) }
            collapsingToolbar.title = data?.title
            tvContent.text = data?.content ?: getString(R.string.text_null)
            tvDate.text = data?.createdAt?.toDate()?.formatTo(dateFormat = DATE_FORMAT_ARTICLE)
            tvContributor.text = data?.contributorName ?: getString(R.string.text_null)
        }
    }

    companion object {
        const val ARTICLE_DATA = "article_data"
    }
}