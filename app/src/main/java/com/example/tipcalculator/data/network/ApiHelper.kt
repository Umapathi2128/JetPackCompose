package com.example.tipcalculator.data.network

class ApiHelper : RetrofitBuilder() {

    private fun initRetrofit(): ApiService {
        return getNewsList().create(ApiService::class.java)
    }

    private fun initMovies(): ApiService {
        return getMoviesList().create(ApiService::class.java)
    }

    suspend fun getNewsList(country: String?, category: String?) =
        initRetrofit().getNewsList(country, category)

    suspend fun getMoviesLists() = initMovies().getMoviesList()
}