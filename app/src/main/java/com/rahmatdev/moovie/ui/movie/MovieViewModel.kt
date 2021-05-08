package com.rahmatdev.moovie.ui.movie

import androidx.lifecycle.ViewModel
import com.rahmatdev.moovie.data.MovieEntity
import com.rahmatdev.moovie.utils.DataDummy

class MovieViewModel : ViewModel() {

    fun getMovies(): List<MovieEntity> = DataDummy.generateDummyMovies()
}