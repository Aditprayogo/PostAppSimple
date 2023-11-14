package com.aditPrayogo.myapplication.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aditPrayogo.myapplication.R
import com.aditprayogo.core.domain.model.Article

class MainAdapter : RecyclerView.Adapter<MainViewHolder>() {

    private var articles = mutableListOf<Article>()

    fun setData(data : MutableList<Article>) {
        this.articles = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row_article, parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(articles[position])
    }

    override fun getItemCount(): Int = articles.size
}