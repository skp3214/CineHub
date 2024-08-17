package com.skp3214.cinehubmovielistapp

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.BufferedReader
import java.io.InputStreamReader

fun loadMoviesFromJson(context: Context): List<Movie> {
    val inputStream = context.resources.openRawResource(R.raw.movies)
    val bufferedReader = BufferedReader(InputStreamReader(inputStream))
    val jsonString = bufferedReader.use { it.readText() }

    val gson = Gson()
    val movieListType = object : TypeToken<List<Movie>>() {}.type
    return gson.fromJson(jsonString, movieListType)
}
