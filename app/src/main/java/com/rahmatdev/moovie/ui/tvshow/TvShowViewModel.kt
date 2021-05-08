package com.rahmatdev.moovie.ui.tvshow

import androidx.lifecycle.ViewModel
import com.rahmatdev.moovie.data.TvShowEntity
import com.rahmatdev.moovie.utils.DataDummy

class TvShowViewModel : ViewModel() {

    fun getTvShows(): List<TvShowEntity> = DataDummy.generateDummyTvShows()
}