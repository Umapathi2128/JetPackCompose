package com.example.tipcalculator.data.repository

import com.example.tipcalculator.data.model.Movie
import com.example.tipcalculator.data.model.NewsListModel
import com.example.tipcalculator.data.network.ApiHelper
import retrofit2.Response

class DataManager(var apiHelper: ApiHelper = ApiHelper()) : DataHelper {

    override suspend fun getNewsList(country: String?, category: String?): Response<NewsListModel> {
        return apiHelper.getNewsList(country, category)
    }

    override suspend fun getMoviesList(): ArrayList<Movie> {
        return apiHelper.getMoviesLists()
    }
}