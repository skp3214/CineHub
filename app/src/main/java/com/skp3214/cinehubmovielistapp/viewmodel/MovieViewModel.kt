package com.skp3214.cinehubmovielistapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.skp3214.cinehubmovielistapp.models.Movie
import com.skp3214.cinehubmovielistapp.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieViewModel(private val repository: MovieRepository) : ViewModel() {

    private val _movies = MutableLiveData<List<Movie>>()
    private val movies: LiveData<List<Movie>> = _movies

    fun loadMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            val movieList = repository.getMovies()
            _movies.postValue(movieList)
        }
    }

    fun getMoviesByGenre(genre: String): List<Movie> {
        if(genre=="Popular Movies"){
            return movies.value?.filterIndexed { index, _ -> index%3 == 1 }?: emptyList()
        }
        return movies.value?.filter { it.genres.contains(genre) } ?: emptyList()
    }

    fun getMovieByTitle(title: String): Movie? {
        return movies.value?.find { it.title == title }
    }

    class Factory(private val repository: MovieRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MovieViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return MovieViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}