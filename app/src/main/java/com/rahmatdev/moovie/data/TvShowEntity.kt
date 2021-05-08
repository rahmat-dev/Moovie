package com.rahmatdev.moovie.data

data class TvShowEntity(
    var tvShowId: Int,
    var title: String,
    var overview: String,
    var release_at: String,
    var vote_average: Double,
    var genres: String,
    var total_episodes: Int,
    var poster_path: String
)
