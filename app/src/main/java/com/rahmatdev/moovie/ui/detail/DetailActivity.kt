package com.rahmatdev.moovie.ui.detail

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.rahmatdev.moovie.R
import com.rahmatdev.moovie.data.MovieEntity
import com.rahmatdev.moovie.data.TvShowEntity
import com.rahmatdev.moovie.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var activityDetailBinding: ActivityDetailBinding

    companion object {
        const val TYPE = "type"
        const val MOVIE_ID = "movie_id"
        const val TV_SHOW_ID = "tv_show_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityDetailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(activityDetailBinding.root)

        showDetailContent()

        setSupportActionBar(activityDetailBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun showDetailContent() {
        val extras = intent.extras
        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailViewModel::class.java]
        if (extras != null) {
            val type = extras.getString(TYPE)
            if (type != null) {
                when(type) {
                    "movie" -> {
                        val movieId = extras.getInt(MOVIE_ID)
                        viewModel.setSelectedMovieId(movieId)
                        val movie = viewModel.getSelectedMovie()
                        populateMovie(movie)
                    }
                    "tv_show" -> {
                        val tvShowId = extras.getInt(TV_SHOW_ID)
                        viewModel.setSelectedTvShowId(tvShowId)
                        val tvShow = viewModel.getSelectedTvShow()
                        Log.d("data tvshow", tvShow.toString())
                        populateTvShow(tvShow)
                    }
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    fun populateMovie(movie: MovieEntity) {
        with(activityDetailBinding.detailContent) {
            tvTitle.text = movie.title
            tvReleaseAt.text = "(${movie.release_date.substring(0, 4)})"
            tvDuration.text = movie.duration
            tvOverviews.text = movie.overview
            tvGenres.text = movie.genres
            tvLabelDuration.visibility = View.VISIBLE
            tvDuration.visibility = View.VISIBLE

            ratingBar.rating = (movie.vote_average / 2).toFloat()
            ratingAverage.text = "(${movie.vote_average}/10)"

            val requestOptions = RequestOptions()
            requestOptions.transform(RoundedCorners(16))
            requestOptions.placeholder(R.drawable.ic_loading)
            requestOptions.error(R.drawable.ic_error)
            Glide.with(this@DetailActivity)
                    .load(movie.poster_path)
                    .apply(requestOptions)
                    .into(imagePoster)
        }

        activityDetailBinding.fab.setOnClickListener {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                    .from(this)
                    .setType(mimeType)
                    .setChooserTitle("Beritahu film ini ke yang lain")
                    .setText("Yuk nonton film ${movie.title}, ratingnya (${movie.vote_average}/10) loh!!")
                    .startChooser()
        }
    }

    @SuppressLint("SetTextI18n")
    fun populateTvShow(tvShow: TvShowEntity) {
        with(activityDetailBinding.detailContent) {
            tvTitle.text = tvShow.title
            tvReleaseAt.text = "(${tvShow.release_at})"
            tvTotalEpisodes.text = "${tvShow.total_episodes} episodes"
            tvOverviews.text = tvShow.overview
            tvGenres.text = tvShow.genres
            tvLabelTotalEpisodes.visibility = View.VISIBLE
            tvTotalEpisodes.visibility = View.VISIBLE

            ratingBar.rating = (tvShow.vote_average / 2).toFloat()
            ratingAverage.text = "(${tvShow.vote_average}/10)"

            val requestOptions = RequestOptions()
            requestOptions.transform(RoundedCorners(16))
            requestOptions.placeholder(R.drawable.ic_loading)
            requestOptions.error(R.drawable.ic_error)
            Glide.with(this@DetailActivity)
                    .load(tvShow.poster_path)
                    .apply(requestOptions)
                    .into(imagePoster)
        }

        activityDetailBinding.fab.setOnClickListener {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                    .from(this)
                    .setType(mimeType)
                    .setChooserTitle("Beritahu series ini ke yang lain")
                    .setText("Yuk nonton series ${tvShow.title}, ratingnya (${tvShow.vote_average}/10) loh!!")
                    .startChooser()
        }
    }
}