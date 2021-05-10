package com.rahmatdev.moovie.ui.splash

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.rahmatdev.moovie.R
import org.junit.Rule
import org.junit.Test

class SplashScreenActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(SplashScreenActivity::class.java)

    @Test
    fun loadSplashScreen() {
        onView(withId(R.id.image_splash)).check(matches(isDisplayed()))
    }
}