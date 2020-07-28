package com.example.weathertestpsa.feature.splash

import androidx.lifecycle.LiveData

/**
 * Created by zaineb on 28/07/2020
 */
object SplashContract {
    interface SplashViewModelContract {
        fun observeGoToHomeAndClose(): LiveData<Boolean>
        fun observeDelay()
    }

    interface SplashActivityContract {
        fun initObservation()
        fun navigateToHome()
    }
}