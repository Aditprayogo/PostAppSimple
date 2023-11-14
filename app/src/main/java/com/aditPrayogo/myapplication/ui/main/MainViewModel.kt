package com.aditPrayogo.myapplication.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aditprayogo.core.domain.model.Article
import com.aditprayogo.core.domain.usecase.ArticleUseCase
import com.aditprayogo.core.utils.state.LoaderState
import com.aditprayogo.core.utils.state.ResultState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

interface MainViewModelContract {
    fun getArticles()
}

@HiltViewModel
class MainViewModel @Inject constructor(
    private val articleUseCase: ArticleUseCase
) : ViewModel(), MainViewModelContract {

    private val _state = MutableLiveData<LoaderState>()
    val state: LiveData<LoaderState> get() = _state

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    private val _networkError = MutableLiveData<Boolean>()
    val networkError: LiveData<Boolean> get() = _networkError

    private val _resultArticles = MutableLiveData<List<Article>>()
    val resultArticles: LiveData<List<Article>> get() = _resultArticles

    init {
        getArticles()
    }

    override fun getArticles() {
        _state.value = LoaderState.ShowLoading
        viewModelScope.launch {
            articleUseCase.getArticles().collect {
                _state.value = LoaderState.HideLoading
                when(it) {
                    is ResultState.Success -> _resultArticles.postValue(it.data)
                    is ResultState.Error -> _error.postValue(it.error)
                    is ResultState.NetworkError -> _networkError.postValue(true)
                }
            }
        }
    }
}