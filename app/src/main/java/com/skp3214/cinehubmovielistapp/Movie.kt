package com.skp3214.cinehubmovielistapp

data class Movie(
    val title: String,
    val genres: List<String>,
    val runtime: Int,
    val cast: List<String>,
    val poster: String,
    val fullplot: String,
    val released: ReleasedDate,
    val directors: List<String>,
    val rated: String,
    val imdb: Imdb,
    val countries: List<String>,
    val writers:List<String>
)

data class Imdb(
    val rating: Double,
    val votes: Int,
    val id: Int
)

data class ReleasedDate(
    val date: String
)

