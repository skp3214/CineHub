package com.skp3214.cinehubmovielistapp.utils

import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

fun formatReleaseDate(releaseDate: String): String {
   val zonedDateTime = ZonedDateTime.parse(releaseDate)
   val formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy")
   return zonedDateTime.format(formatter)
}
