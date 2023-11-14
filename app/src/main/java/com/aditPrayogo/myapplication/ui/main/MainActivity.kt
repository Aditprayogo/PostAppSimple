package com.aditPrayogo.myapplication.ui.main

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.aditPrayogo.myapplication.databinding.ActivityMainBinding
import com.aditprayogo.core.domain.model.Article
import com.aditprayogo.core.utils.state.LoaderState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val mainAdapter: MainAdapter by lazy {
        MainAdapter()
    }

    private val mainViewModel: MainViewModel by viewModels()

    private var articleData = mutableListOf<Article>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initRecyclerView()
        initObservers()
        initSwipe()
    }

    private fun initSwipe() {
        binding.apply {
            swipeView.setOnRefreshListener {
                mainViewModel.getArticles()
                swipeView.isRefreshing = false
            }
        }
    }

    private fun initObservers() {
        with(mainViewModel) {
            state.observe(this@MainActivity) {
                handleStateLoading(it)
            }
            resultArticles.observe(this@MainActivity) {
                handleArticlesResult(it)
            }
            error.observe(this@MainActivity) {
                Toast.makeText(applicationContext, it, Toast.LENGTH_SHORT).show()
            }
            networkError.observe(this@MainActivity) {
                handleNetworkError(it)
            }
        }
    }

    private fun handleNetworkError(state: Boolean) {
        with(binding) {
            if (state) {
                baseLoading.root.visibility = View.VISIBLE
                rvArticle.visibility = View.INVISIBLE
            } else {
                baseLoading.root.visibility = View.INVISIBLE
                rvArticle.visibility = View.VISIBLE
            }
        }
    }

    private fun handleStateLoading(it: LoaderState) {
        with(binding) {
            if (it is LoaderState.ShowLoading) {
                baseLoading.root.visibility = View.VISIBLE
                rvArticle.visibility = View.INVISIBLE
            } else {
                baseLoading.root.visibility = View.INVISIBLE
                rvArticle.visibility = View.VISIBLE
            }
        }
    }

    private fun initRecyclerView() {
        with(binding) {
            rvArticle.apply {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                adapter = mainAdapter
            }
        }
    }

    private fun handleArticlesResult(data: List<Article>) {
        articleData.clear()
        articleData.addAll(data)
        mainAdapter.setData(articleData)
    }
}