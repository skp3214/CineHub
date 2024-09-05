package com.skp3214.cinehubmovielistapp.repository


import android.content.Context
import com.skp3214.cinehubmovielistapp.models.Movie
import com.skp3214.cinehubmovielistapp.utils.loadMoviesFromJson

class MovieRepository(private val context: Context) {

    fun getMovies(): List<Movie> {
        return loadMoviesFromJson(context)
    }
}
