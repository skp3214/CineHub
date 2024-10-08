package com.skp3214.cinehubmovielistapp.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.skp3214.cinehubmovielistapp.ui.theme.Black40
import androidx.compose.ui.layout.ContentScale
import com.skp3214.cinehubmovielistapp.models.Movie
import com.skp3214.cinehubmovielistapp.viewmodel.MovieViewModel
import androidx.compose.ui.Modifier

@Composable
fun MovieListScreen(navController: NavController, movieViewModel: MovieViewModel) {
    val genres = listOf(
        "Popular Movies", "Fantasy", "Thriller", "Horror", "Drama",
        "Romance", "Crime", "Comedy", "Animation", "Action",
        "Adventure", "Biography"
    )
    val moviesByGenre = remember { mutableStateOf(mapOf<String, List<Movie>>()) }

    LaunchedEffect(Unit) {
        val movies = mutableMapOf<String, List<Movie>>()
        genres.forEach { genre ->
            movies[genre] = movieViewModel.getMoviesByGenre(genre)
        }
        moviesByGenre.value = movies
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Black40)
            .padding(16.dp)
    ) {
        MovieSearchComponent(onSearchClicked = { query ->
            if (query.isNotBlank()) {
                navController.navigate("search_results/$query")
            }
        })
        LazyColumn {
            genres.forEach { genre ->
                item {
                    Text(
                        genre,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                    LazyRow(
                        modifier = Modifier.height(250.dp)
                    ) {
                        val filteredMovies = moviesByGenre.value[genre] ?: emptyList()

                        items(filteredMovies) { movie ->
                            MovieItemHorizontal(movie) {
                                navController.navigate("movie_detail/${movie.title}")
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MovieItemHorizontal(movie: Movie, onMovieClick: (Movie) -> Unit) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .clickable { onMovieClick(movie) }
            .width(150.dp)
            .fillMaxHeight()
    ) {
        Image(
            painter = coil.compose.rememberAsyncImagePainter(movie.poster),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8))
                .height(200.dp)
        )
        Text(
            movie.title,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(4.dp)
        )
    }
}

