package com.skp3214.cinehubmovielistapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.skp3214.cinehubmovielistapp.view.MovieDetailScreen
import com.skp3214.cinehubmovielistapp.view.MovieListScreen
import com.skp3214.cinehubmovielistapp.view.SearchResultsScreen
import com.skp3214.cinehubmovielistapp.viewmodel.MovieViewModel

@Composable
fun MovieAppNavHost(movieViewModel: MovieViewModel, navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = "movie_list") {
        composable("movie_list") {
            MovieListScreen(navController, movieViewModel)
        }
        composable("search_results/{query}") { backStackEntry ->
            val query = backStackEntry.arguments?.getString("query") ?: ""
            SearchResultsScreen(navController, movieViewModel, query)
        }
        composable("movie_detail/{movieTitle}") { backStackEntry ->
            val movieTitle = backStackEntry.arguments?.getString("movieTitle")
            movieTitle?.let {
                MovieDetailScreen(it, movieViewModel)
            }
        }
    }
}
