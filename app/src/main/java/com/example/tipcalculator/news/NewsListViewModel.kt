package com.example.tipcalculator.news

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tipcalculator.data.model.Article
import com.example.tipcalculator.data.model.Movie
import com.example.tipcalculator.data.model.NewsListModel
import com.example.tipcalculator.data.repository.DataManager
import com.example.tipcalculator.utils.NetworkHelper
import com.example.tipcalculator.utils.Resource
import kotlinx.coroutines.launch

class NewsListViewModel(var networkHelper: NetworkHelper, var dataManager: DataManager) :
    ViewModel() {

    private var _newsList: MutableLiveData<Resource<NewsListModel>> = MutableLiveData()
    val newList: LiveData<Resource<NewsListModel>>
        get() = _newsList


    var moviesResponse : List<Article> by mutableStateOf(listOf())


    fun getNews(country: String, category: String) {

        viewModelScope.launch {

            try {
                val data = dataManager.getNewsList(country, category)
                moviesResponse = data.body()?.articles!!
            }catch (e : Exception){
                e.printStackTrace()
            }

//            _newsList.value = Resource.loading(null)
//            if (networkHelper.isNetworkConnected()) {
//
//                dataManager.getNewsList(country, category).let {
//                    if (it.isSuccessful) {
//                        _newsList.value = Resource.success(it.body())
//                    } else {
//                        _newsList.value = Resource.error(null, "No Internet")
//                    }
//                }
//            } else {
//                _newsList.value = Resource.error(null, "No Internet")
//            }
        }
    }
}