package com.skp3214.cinehubmovielistapp.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.skp3214.cinehubmovielistapp.models.Movie
import com.skp3214.cinehubmovielistapp.viewmodel.MovieViewModel
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.core.graphics.toColorInt

@Composable
fun SearchResultsScreen(
    navController: NavController,
    movieViewModel: MovieViewModel,
    initialSearchQuery: String
) {
    var searchQuery by remember { mutableStateOf(initialSearchQuery) }
    var searchedMovies by remember { mutableStateOf(listOf<Movie>()) }

    LaunchedEffect(searchQuery) {
        if (searchQuery.isNotBlank()) {
            searchedMovies = movieViewModel.searchMovies(searchQuery)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ) {
        MovieSearchComponent(onSearchClicked = { query ->
            if (query.isNotBlank()) {
                searchQuery = query
            }
        })

        if(searchedMovies.isEmpty()) {
            Text(
                text = "No movies found for ${searchQuery.uppercase()}",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp)
            )
        }
        else {
            Text(
                text = "Movies found for ${searchQuery.uppercase()}",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp)
            )
        }

        LazyColumn {
            items(searchedMovies) { movie ->
                MovieItemHorizontal(movie) {
                    navController.navigate("movie_detail/${movie.title}")
                }
            }
        }
    }
}

