package com.rahmatdev.moovie.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rahmatdev.moovie.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val homeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(homeBinding.root)

        val sectionsPageAdapter = SectionsPageAdapter(this, supportFragmentManager)
        homeBinding.viewPager.adapter = sectionsPageAdapter
        homeBinding.tabs.setupWithViewPager(homeBinding.viewPager)

        supportActionBar?.hide()
    }
}