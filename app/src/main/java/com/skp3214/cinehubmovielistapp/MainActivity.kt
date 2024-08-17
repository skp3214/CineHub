package com.skp3214.cinehubmovielistapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.skp3214.cinehubmovielistapp.ui.theme.CineHubMovieListAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val movies = loadMoviesFromJson(this)

        setContent {
            CineHubMovieListAppTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    MovieAppNavHost(movies)
                }
            }
        }
    }
}

@Composable
fun MovieAppNavHost(movies: List<Movie>) {
    val navController: NavHostController = rememberNavController()

    NavHost(navController = navController, startDestination = "movie_list") {
        composable("movie_list") {
            MovieListScreen(movies, navController)
        }
        composable("movie_detail/{movieTitle}") { backStackEntry ->
            val movieTitle = backStackEntry.arguments?.getString("movieTitle")
            val movie = movies.find { it.title == movieTitle }
            movie?.let { MovieDetailScreen(it) }
        }
    }
}
