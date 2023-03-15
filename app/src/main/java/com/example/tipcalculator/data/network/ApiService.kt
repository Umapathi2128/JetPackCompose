package com.example.tipcalculator.data.network

import com.example.tipcalculator.data.model.Movie
import com.example.tipcalculator.data.model.NewsListModel
import com.example.tipcalculator.utils.Constants
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("top-headlines?apiKey=${Constants.NEWS_API_KEY}")
   suspend fun getNewsList(
        @Query("country") country : String?,
        @Query("category") category : String?
    ) : Response<NewsListModel>


    @GET("movielist.json")
    suspend fun getMoviesList() : ArrayList<Movie>


//    companion object {
//        var apiService: ApiService? = null
//        fun getInstance() : ApiService {
//            if (apiService == null) {
//                apiService = Retrofit.Builder()
//                    .baseUrl("https://howtodoandroid.com/apis/")
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build().create(ApiService::class.java)
//            }
//            return apiService!!
//        }
//    }

}