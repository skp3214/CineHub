package com.skp3214.cinehubmovielistapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.skp3214.cinehubmovielistapp.ui.theme.Black40
import androidx.compose.ui.layout.ContentScale
@Composable
fun MovieListScreen(movies: List<Movie>, navController: NavController) {

    val genres = listOf(
        "Popular Movies", "Fantasy", "Thriller", "Horror", "Drama",
        "Romance", "Crime", "Comedy", "Animation", "Action",
        "Adventure", "Biography"
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Black40)
    ) {
        LazyColumn(modifier = Modifier.padding(16.dp)) {
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
                        val filteredMovies = if (genre == "Popular Movies") {
                            movies.filterIndexed { index, _ -> index % 2 == 1 }
                        } else {
                            movies.filter { it.genres.contains(genre) }
                        }

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
