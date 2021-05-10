package com.rahmatdev.moovie.ui.detail

import androidx.lifecycle.ViewModel
import com.rahmatdev.moovie.data.MovieEntity
import com.rahmatdev.moovie.data.TvShowEntity
import com.rahmatdev.moovie.utils.DataDummy
import kotlin.properties.Delegates

class DetailViewModel : ViewModel() {
    private var movieId by Delegates.notNull<Int>()
    private var tvShowId by Delegates.notNull<Int>()

    fun setSelectedMovieId(movieId: Int) {
        this.movieId = movieId
    }

    fun setSelectedTvShowId(tvShowId: Int) {
        this.tvShowId = tvShowId
    }

    fun getSelectedMovie(): MovieEntity {
        lateinit var movie: MovieEntity
        val moviesEntities = DataDummy.generateDummyMovies()

        for (movieEntitity in moviesEntities) {
            if (movieEntitity.movieId == movieId) {
                movie = movieEntitity
            }
        }
        return movie
    }

    fun getSelectedTvShow(): TvShowEntity {
        lateinit var tvShow: TvShowEntity
        val tvShowsEntities = DataDummy.generateDummyTvShows()

        for (tvShowEntity in tvShowsEntities) {
            if (tvShowEntity.tvShowId == tvShowId) {
                tvShow = tvShowEntity
            }
        }
        return tvShow
    }
}