package com.rahmatdev.moovie.ui.detail

import com.rahmatdev.moovie.utils.DataDummy
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class DetailViewModelTest {
    private lateinit var viewModel: DetailViewModel
    private val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val movieId = dummyMovie.movieId
    private val dummyTvShow = DataDummy.generateDummyTvShows()[0]
    private val tvShowId = dummyTvShow.tvShowId

    @Before
    fun setUp() {
        viewModel = DetailViewModel()
        viewModel.setSelectedMovieId(movieId)
        viewModel.setSelectedTvShowId(tvShowId)
    }

    @Test
    fun getSelectedMovie() {
        val movie = viewModel.getSelectedMovie()
        assertNotNull(movie)
        assertEquals(dummyMovie, movie)
    }

    @Test
    fun getSelectedTvShow() {
        val tvShow = viewModel.getSelectedTvShow()
        assertNotNull(tvShow)
        assertEquals(dummyTvShow, tvShow)
    }
}