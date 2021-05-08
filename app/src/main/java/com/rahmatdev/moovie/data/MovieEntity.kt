package com.rahmatdev.moovie.data

data class MovieEntity(
    var movieId: Int,
    var title: String,
    var overview: String,
    var release_date: String,
    var vote_average: Double,
    var genres: String,
    var duration: String,
    var poster_path: String
)