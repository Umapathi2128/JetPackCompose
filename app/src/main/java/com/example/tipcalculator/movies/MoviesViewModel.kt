package com.example.tipcalculator.movies

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tipcalculator.data.model.Movie
import com.example.tipcalculator.data.repository.DataManager
import com.example.tipcalculator.utils.NetworkHelper
import kotlinx.coroutines.launch

class MoviesViewModel(var networkHelper: NetworkHelper, var dataManager: DataManager) : ViewModel(){

    var movieListResponse: List<Movie> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")


    fun getMovies() {
        viewModelScope.launch {
            try {
                val moviesList = dataManager.getMoviesList()
                movieListResponse = moviesList
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }

        }
    }

}