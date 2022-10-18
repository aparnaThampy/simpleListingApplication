package com.example.samplelistingapp.feature.listing.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.samplelistingapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ListingFragment.newInstance())
                .commitNow()
        }
    }

    private fun setSplashScreen() {
        // Handle the splash screen transition.
        installSplashScreen()
    }
}
