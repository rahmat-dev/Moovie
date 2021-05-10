package com.rahmatdev.moovie.ui.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.rahmatdev.moovie.R
import com.rahmatdev.moovie.data.TvShowEntity
import com.rahmatdev.moovie.databinding.ItemsTvShowBinding
import com.rahmatdev.moovie.ui.detail.DetailActivity

class TvShowAdapter : RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {
    private val listTvShows = ArrayList<TvShowEntity>()

    fun setTvShows(tvShows: List<TvShowEntity>?) {
        if (tvShows == null) return
        listTvShows.clear()
        listTvShows.addAll(tvShows)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TvShowViewHolder {
        val itemsTvShowBinding = ItemsTvShowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(itemsTvShowBinding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val tvShow = listTvShows[position]
        holder.bind(tvShow)
    }

    override fun getItemCount(): Int = listTvShows.size

    class TvShowViewHolder(private val binding: ItemsTvShowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TvShowEntity) {
            with(binding) {
                tvTitle.text = tvShow.title
                tvGenres.text = tvShow.genres
                tvRating.text = tvShow.vote_average.toString()
                tvReleaseAt.text = tvShow.release_at

                val requestOptions = RequestOptions()
                requestOptions.transform(RoundedCorners(16))
                requestOptions.placeholder(R.drawable.ic_loading)
                requestOptions.error(R.drawable.ic_error)

                Glide.with(itemView)
                    .load(tvShow.poster_path)
                    .apply(requestOptions)
                    .into(moviePoster)

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.TYPE, "tv_show")
                    intent.putExtra(DetailActivity.TV_SHOW_ID, tvShow.tvShowId)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}