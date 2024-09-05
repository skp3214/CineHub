package com.skp3214.cinehubmovielistapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.skp3214.cinehubmovielistapp.navigation.MovieAppNavHost
import com.skp3214.cinehubmovielistapp.ui.theme.CineHubMovieListAppTheme
import com.skp3214.cinehubmovielistapp.viewmodel.MovieViewModel
import com.skp3214.cinehubmovielistapp.repository.MovieRepository

class MainActivity : ComponentActivity() {
    private lateinit var movieViewModel: MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repository = MovieRepository(this) // You might need to instantiate this properly
        val factory = MovieViewModel.Factory(repository)
        movieViewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]

        movieViewModel.loadMovies()

        setContent {
            CineHubMovieListAppTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    MovieAppNavHost(movieViewModel)
                }
            }
        }
    }
}