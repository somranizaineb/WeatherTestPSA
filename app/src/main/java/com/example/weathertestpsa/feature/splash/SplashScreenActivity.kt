package com.example.weathertestpsa.feature.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.weathertestpsa.R
import com.example.weathertestpsa.feature.weather.WeatherActivity

class SplashScreenActivity : AppCompatActivity(), SplashContract.SplashActivityContract {
    ///////////////////////////////////////////////////////////////////////////
    // PROPERTIES SECTION
    ///////////////////////////////////////////////////////////////////////////
    private lateinit var splashViewModel: SplashContract.SplashViewModelContract

    ///////////////////////////////////////////////////////////////////////////
    // ACTIVITY LIFECYCLE HANDLING
    ///////////////////////////////////////////////////////////////////////////

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        splashViewModel = ViewModelProviders.of(this).get(SplashViewModel::class.java)
        initObservation()
    }

    ///////////////////////////////////////////////////////////////////////////
    // SplachActivityContract IMPLEMENTATION
    ///////////////////////////////////////////////////////////////////////////
    override fun initObservation() {
        splashViewModel
            .observeGoToHomeAndClose()
            .observe(this, Observer {
                navigateToHome()
            })
    }

    override fun navigateToHome() {
        val intent = Intent(this, WeatherActivity::class.java)
        startActivity(intent)
        finish()
    }
}