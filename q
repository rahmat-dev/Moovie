[1mdiff --git a/app/src/main/AndroidManifest.xml b/app/src/main/AndroidManifest.xml[m
[1mindex ed8ef4c..9cd7f53 100644[m
[1m--- a/app/src/main/AndroidManifest.xml[m
[1m+++ b/app/src/main/AndroidManifest.xml[m
[36m@@ -14,7 +14,12 @@[m
         <activity[m
             android:name=".ui.detail.DetailActivity"[m
             android:label="@string/title_activity_detail"[m
[31m-            android:theme="@style/Theme.Moovie.NoActionBar" />[m
[32m+[m[32m            android:parentActivityName=".ui.home.HomeActivity"[m
[32m+[m[32m            android:theme="@style/Theme.Moovie.NoActionBar">[m
[32m+[m[32m            <meta-data[m
[32m+[m[32m                android:name="android.support.PARENT_ACTIVITY"[m
[32m+[m[32m                android:value=".ui.home.HomeActivity" />[m
[32m+[m[32m        </activity>[m
         <activity android:name=".ui.home.HomeActivity">[m
             <intent-filter>[m
                 <action android:name="android.intent.action.MAIN" />[m
[1mdiff --git a/app/src/main/java/com/rahmatdev/moovie/ui/detail/DetailActivity.kt b/app/src/main/java/com/rahmatdev/moovie/ui/detail/DetailActivity.kt[m
[1mindex db69327..e6f86e3 100644[m
[1m--- a/app/src/main/java/com/rahmatdev/moovie/ui/detail/DetailActivity.kt[m
[1m+++ b/app/src/main/java/com/rahmatdev/moovie/ui/detail/DetailActivity.kt[m
[36m@@ -1,23 +1,139 @@[m
 package com.rahmatdev.moovie.ui.detail[m
 [m
[32m+[m[32mimport android.annotation.SuppressLint[m
 import android.os.Bundle[m
[31m-import com.google.android.material.floatingactionbutton.FloatingActionButton[m
[31m-import com.google.android.material.snackbar.Snackbar[m
[32m+[m[32mimport android.util.Log[m
[32m+[m[32mimport android.view.View[m
 import androidx.appcompat.app.AppCompatActivity[m
[32m+[m[32mimport androidx.core.app.ShareCompat[m
[32m+[m[32mimport androidx.lifecycle.ViewModelProvider[m
[32m+[m[32mimport com.bumptech.glide.Glide[m
[32m+[m[32mimport com.bumptech.glide.load.resource.bitmap.RoundedCorners[m
[32m+[m[32mimport com.bumptech.glide.request.RequestOptions[m
 import com.rahmatdev.moovie.R[m
[32m+[m[32mimport com.rahmatdev.moovie.data.MovieEntity[m
[32m+[m[32mimport com.rahmatdev.moovie.data.TvShowEntity[m
 import com.rahmatdev.moovie.databinding.ActivityDetailBinding[m
[32m+[m[32mimport java.text.DecimalFormat[m
 [m
 class DetailActivity : AppCompatActivity() {[m
 [m
[32m+[m[32m    private lateinit var activityDetailBinding: ActivityDetailBinding[m
[32m+[m
[32m+[m[32m    companion object {[m
[32m+[m[32m        const val TYPE = "type"[m
[32m+[m[32m        const val MOVIE_ID = "movie_id"[m
[32m+[m[32m        const val TV_SHOW_ID = "tv_show_id"[m
[32m+[m[32m    }[m
[32m+[m
     override fun onCreate(savedInstanceState: Bundle?) {[m
         super.onCreate(savedInstanceState)[m
 [m
[31m-        val activityDetailBinding = ActivityDetailBinding.inflate(layoutInflater)[m
[32m+[m[32m        activityDetailBinding = ActivityDetailBinding.inflate(layoutInflater)[m
         setContentView(activityDetailBinding.root)[m
 [m
[31m-        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->[m
[31m-            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)[m
[31m-                .setAction("Action", null).show()[m
[32m+[m[32m        showDetailContent()[m
[32m+[m
[32m+[m[32m        setSupportActionBar(activityDetailBinding.toolbar)[m
[32m+[m[32m        supportActionBar?.setDisplayHomeAsUpEnabled(true)[m
[32m+[m[32m    }[m
[32m+[m
[32m+[m[32m    private fun showDetailContent() {[m
[32m+[m[32m        val extras = intent.extras[m
[32m+[m[32m        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailViewModel::class.java][m
[32m+[m[32m        if (extras != null) {[m
[32m+[m[32m            val type = extras.getString(TYPE)[m
[32m+[m[32m            if (type != null) {[m
[32m+[m[32m                when(type) {[m
[32m+[m[32m                    "movie" -> {[m
[32m+[m[32m                        val movieId = extras.getInt(MOVIE_ID)[m
[32m+[m[32m                        viewModel.setSelectedMovieId(movieId)[m
[32m+[m[32m                        val movie = viewModel.getSelectedMovie()[m
[32m+[m[32m                        populateMovie(movie)[m
[32m+[m[32m                    }[m
[32m+[m[32m                    "tv_show" -> {[m
[32m+[m[32m                        val tvShowId = extras.getInt(TV_SHOW_ID)[m
[32m+[m[32m                        viewModel.setSelectedTvShowId(tvShowId)[m
[32m+[m[32m                        val tvShow = viewModel.getSelectedTvShow()[m
[32m+[m[32m                        Log.d("data tvshow", tvShow.toString())[m
[32m+[m[32m                        populateTvShow(tvShow)[m
[32m+[m[32m                    }[m
[32m+[m[32m                }[m
[32m+[m[32m            }[m
[32m+[m[32m        }[m
[32m+[m[32m    }[m
[32m+[m
[32m+[m[32m    @SuppressLint("SetTextI18n")[m
[32m+[m[32m    fun populateMovie(movie: MovieEntity) {[m
[32m+[m[32m        with(activityDetailBinding.detailContent) {[m
[32m+[m[32m            tvTitle.text = movie.title[m
[32m+[m[32m            tvReleaseAt.text = "(${movie.release_date.substring(0, 4)})"[m
[32m+[m[32m            tvDuration.text = movie.duration[m
[32m+[m[32m            tvOverviews.text = movie.overview[m
[32m+[m[32m            tvGenres.text = movie.genres[m
[32m+[m[32m            tvLabelDuration.visibility = View.VISIBLE[m
[32m+[m[32m            tvDuration.visibility = View.VISIBLE[m
[32m+[m[32m            tvLabelTotalEpisodes.visibility = View.GONE[m
[32m+[m[32m            tvTotalEpisodes.visibility = View.GONE[m
[32m+[m
[32m+[m[32m            ratingBar.rating = (movie.vote_average / 2).toFloat()[m
[32m+[m[32m            ratingAverage.text = "(${movie.vote_average}/10)"[m
[32m+[m
[32m+[m[32m            val requestOptions = RequestOptions()[m
[32m+[m[32m            requestOptions.transform(RoundedCorners(16))[m
[32m+[m[32m            requestOptions.placeholder(R.drawable.ic_loading)[m
[32m+[m[32m            requestOptions.error(R.drawable.ic_error)[m
[32m+[m[32m            Glide.with(this@DetailActivity)[m
[32m+[m[32m                    .load(movie.poster_path)[m
[32m+[m[32m                    .apply(requestOptions)[m
[32m+[m[32m                    .into(imagePoster)[m
[32m+[m[32m        }[m
[32m+[m
[32m+[m[32m        activityDetailBinding.fab.setOnClickListener {[m
[32m+[m[32m            val mimeType = "text/plain"[m
[32m+[m[32m            ShareCompat.IntentBuilder[m
[32m+[m[32m                    .from(this)[m
[32m+[m[32m                    .setType(mimeType)[m
[32m+[m[32m                    .setChooserTitle("Beritahu film ini ke yang lain")[m
[32m+[m[32m                    .setText("Yuk nonton film ${movie.title}, ratingnya (${movie.vote_average}/10) loh!!")[m
[32m+[m[32m                    .startChooser()[m
[32m+[m[32m        }[m
[32m+[m[32m    }[m
[32m+[m
[32m+[m[32m    @SuppressLint("SetTextI18n")[m
[32m+[m[32m    fun populateTvShow(tvShow: TvShowEntity) {[m
[32m+[m[32m        with(activityDetailBinding.detailContent) {[m
[32m+[m[32m            tvTitle.text = tvShow.title[m
[32m+[m[32m            tvReleaseAt.text = "(${tvShow.release_at})"[m
[32m+[m[32m            tvTotalEpisodes.text = "${tvShow.total_episodes} episodes"[m
[32m+[m[32m            tvOverviews.text = tvShow.overview[m
[32m+[m[32m            tvGenres.text = tvShow.genres[m
[32m+[m[32m            tvLabelTotalEpisodes.visibility = View.VISIBLE[m
[32m+[m[32m            tvTotalEpisodes.visibility = View.VISIBLE[m
[32m+[m[32m            tvLabelDuration.visibility = View.GONE[m
[32m+[m[32m            tvDuration.visibility = View.GONE[m
[32m+[m
[32m+[m[32m            ratingBar.rating = (tvShow.vote_average / 2).toFloat()[m
[32m+[m[32m            ratingAverage.text = "(${tvShow.vote_average}/10)"[m
[32m+[m
[32m+[m[32m            val requestOptions = RequestOptions()[m
[32m+[m[32m            requestOptions.transform(RoundedCorners(16))[m
[32m+[m[32m            requestOptions.placeholder(R.drawable.ic_loading)[m
[32m+[m[32m            requestOptions.error(R.drawable.ic_error)[m
[32m+[m[32m            Glide.with(this@DetailActivity)[m
[32m+[m[32m                    .load(tvShow.poster_path)[m
[32m+[m[32m                    .apply(requestOptions)[m
[32m+[m[32m                    .into(imagePoster)[m
[32m+[m[32m        }[m
[32m+[m
[32m+[m[32m        activityDetailBinding.fab.setOnClickListener {[m
[32m+[m[32m            val mimeType = "text/plain"[m
[32m+[m[32m            ShareCompat.IntentBuilder[m
[32m+[m[32m                    .from(this)[m
[32m+[m[32m                    .setType(mimeType)[m
[32m+[m[32m                    .setChooserTitle("Beritahu series ini ke yang lain")[m
[32m+[m[32m                    .setText("Yuk nonton series ${tvShow.title}, ratingnya (${tvShow.vote_average}/10) loh!!")[m
[32m+[m[32m                    .startChooser()[m
         }[m
     }[m
 }[m
\ No newline at end of file[m
[1mdiff --git a/app/src/main/java/com/rahmatdev/moovie/ui/movie/MovieAdapter.kt b/app/src/main/java/com/rahmatdev/moovie/ui/movie/MovieAdapter.kt[m
[1mindex b21f149..19d0fad 100644[m
[1m--- a/app/src/main/java/com/rahmatdev/moovie/ui/movie/MovieAdapter.kt[m
[1m+++ b/app/src/main/java/com/rahmatdev/moovie/ui/movie/MovieAdapter.kt[m
[36m@@ -1,5 +1,6 @@[m
 package com.rahmatdev.moovie.ui.movie[m
 [m
[32m+[m[32mimport android.content.Intent[m
 import android.view.LayoutInflater[m
 import android.view.ViewGroup[m
 import androidx.recyclerview.widget.RecyclerView[m
[36m@@ -9,6 +10,7 @@[m [mimport com.bumptech.glide.request.RequestOptions[m
 import com.rahmatdev.moovie.R[m
 import com.rahmatdev.moovie.data.MovieEntity[m
 import com.rahmatdev.moovie.databinding.ItemsMovieBinding[m
[32m+[m[32mimport com.rahmatdev.moovie.ui.detail.DetailActivity[m
 [m
 class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {[m
     private val listMovies = ArrayList<MovieEntity>()[m
[36m@@ -51,6 +53,13 @@[m [mclass MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {[m
                     .load(movie.poster_path)[m
                     .apply(requestOptions)[m
                     .into(moviePoster)[m
[32m+[m
[32m+[m[32m                itemView.setOnClickListener {[m
[32m+[m[32m                    val intent = Intent(itemView.context, DetailActivity::class.java)[m
[32m+[m[32m                    intent.putExtra(DetailActivity.TYPE, "movie")[m
[32m+[m[32m                    intent.putExtra(DetailActivity.MOVIE_ID, movie.movieId)[m
[32m+[m[32m                    itemView.context.startActivity(intent)[m
[32m+[m[32m                }[m
             }[m
         }[m
     }[m
[1mdiff --git a/app/src/main/java/com/rahmatdev/moovie/ui/tvshow/TvShowAdapter.kt b/app/src/main/java/com/rahmatdev/moovie/ui/tvshow/TvShowAdapter.kt[m
[1mindex 587823e..61ce2bf 100644[m
[1m--- a/app/src/main/java/com/rahmatdev/moovie/ui/tvshow/TvShowAdapter.kt[m
[1m+++ b/app/src/main/java/com/rahmatdev/moovie/ui/tvshow/TvShowAdapter.kt[m
[36m@@ -1,5 +1,6 @@[m
 package com.rahmatdev.moovie.ui.tvshow[m
 [m
[32m+[m[32mimport android.content.Intent[m
 import android.view.LayoutInflater[m
 import android.view.ViewGroup[m
 import androidx.recyclerview.widget.RecyclerView[m
[36m@@ -9,6 +10,7 @@[m [mimport com.bumptech.glide.request.RequestOptions[m
 import com.rahmatdev.moovie.R[m
 import com.rahmatdev.moovie.data.TvShowEntity[m
 import com.rahmatdev.moovie.databinding.ItemsTvShowBinding[m
[32m+[m[32mimport com.rahmatdev.moovie.ui.detail.DetailActivity[m
 [m
 class TvShowAdapter : RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {[m
     private val listTvShows = ArrayList<TvShowEntity>()[m
[36m@@ -51,6 +53,13 @@[m [mclass TvShowAdapter : RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {[m
                     .load(tvShow.poster_path)[m
                     .apply(requestOptions)[m
                     .into(moviePoster)[m
[32m+[m
[32m+[m[32m                itemView.setOnClickListener {[m
[32m+[m[32m                    val intent = Intent(itemView.context, DetailActivity::class.java)[m
[32m+[m[32m                    intent.putExtra(DetailActivity.TYPE, "tv_show")[m
[32m+[m[32m                    intent.putExtra(DetailActivity.TV_SHOW_ID, tvShow.tvShowId)[m
[32m+[m[32m                    itemView.context.startActivity(intent)[m
[32m+[m[32m                }[m
             }[m
         }[m
     }[m
[1mdiff --git a/app/src/main/res/layout/activity_detail.xml b/app/src/main/res/layout/activity_detail.xml[m
[1mindex 85974de..d1a1a11 100644[m
[1m--- a/app/src/main/res/layout/activity_detail.xml[m
[1m+++ b/app/src/main/res/layout/activity_detail.xml[m
[36m@@ -6,7 +6,21 @@[m
     android:layout_height="match_parent"[m
     tools:context=".ui.detail.DetailActivity">[m
 [m
[31m-    <include layout="@layout/content_detail" />[m
[32m+[m[32m    <com.google.android.material.appbar.AppBarLayout[m
[32m+[m[32m        android:layout_width="match_parent"[m
[32m+[m[32m        android:layout_height="wrap_content"[m
[32m+[m[32m        android:theme="@style/ThemeOverlay.MaterialComponents.Dark.ActionBar">[m
[32m+[m
[32m+[m[32m        <androidx.appcompat.widget.Toolbar[m
[32m+[m[32m            android:id="@+id/toolbar"[m
[32m+[m[32m            android:layout_width="match_parent"[m
[32m+[m[32m            android:layout_height="?attr/actionBarSize"[m
[32m+[m[32m            android:background="?attr/colorPrimary"[m
[32m+[m[32m            app:popupTheme="@style/ThemeOverlay.MaterialComponents.Light" />[m
[32m+[m
[32m+[m[32m    </com.google.android.material.appbar.AppBarLayout>[m
[32m+[m
[32m+[m[32m    <include android:id="@+id/detail_content" layout="@layout/content_detail" />[m
 [m
     <com.google.android.material.floatingactionbutton.FloatingActionButton[m
         android:id="@+id/fab"[m
[1mdiff --git a/app/src/main/res/layout/content_detail.xml b/app/src/main/res/layout/content_detail.xml[m
[1mindex 4124312..9aff683 100644[m
[1m--- a/app/src/main/res/layout/content_detail.xml[m
[1m+++ b/app/src/main/res/layout/content_detail.xml[m
[36m@@ -62,6 +62,7 @@[m
                 android:stepSize="0.1"[m
                 android:progressTint="@color/gold"[m
                 android:progressBackgroundTint="@color/lightgray_50"[m
[32m+[m[32m                android:secondaryProgressTint="@color/transparent"[m
                 tools:rating="3.5" />[m
 [m
             <TextView[m
[1mdiff --git a/app/src/main/res/values/colors.xml b/app/src/main/res/values/colors.xml[m
[1mindex e9bc074..876a2c6 100644[m
[1m--- a/app/src/main/res/values/colors.xml[m
[1m+++ b/app/src/main/res/values/colors.xml[m
[36m@@ -13,4 +13,5 @@[m
     <color name="darkblue_500">#FF374151</color>[m
     <color name="darkblue_700">#FF1B2331</color>[m
     <color name="gold">#FFFAA51E</color>[m
[32m+[m[32m    <color name="transparent">#00000000</color>[m
 </resources>[m
\ No newline at end of file[m
