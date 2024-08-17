package com.skp3214.cinehubmovielistapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.skp3214.cinehubmovielistapp.ui.theme.Black40
import com.skp3214.cinehubmovielistapp.ui.theme.Red40

@Composable
fun MovieDetailScreen(movie: Movie) {
    val scrollState = rememberScrollState()
    val releaseDate = movie.released.date
    val formattedDate = formatReleaseDate(releaseDate)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Black40)
            .padding(16.dp)
            .verticalScroll(scrollState)
    ) {
        Column {
            Image(
                painter = rememberAsyncImagePainter(movie.poster),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(550.dp)
                    .clip(MaterialTheme.shapes.medium)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = movie.title,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                style = MaterialTheme.typography.headlineSmall,
                color = Color.White,
                )
            Spacer(modifier = Modifier.height(8.dp))
            DetailText(label = "Genres", value = movie.genres.joinToString(", "))
            DetailText(label = "Runtime", value = "${movie.runtime} minutes")
            DetailText(label = "Rated", value = movie.rated)
            DetailText(label = "Plot", value = movie.fullplot)
            DetailText(label = "Cast", value = movie.cast.joinToString(", "))
            DetailText(label = "Release Date", value = formattedDate)
            DetailText(label = "Writers", value = movie.writers.joinToString(","))
            DetailText(label = "Director", value = movie.directors.joinToString(", "))
        }
    }
}

@Composable
fun DetailText(label: String, value: String) {
    Column(modifier = Modifier.padding(vertical = 4.dp)) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Red40
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = value,
            style = MaterialTheme.typography.bodyLarge,
            color = Color.White,
            fontSize = 20.sp
            )
    }
}
