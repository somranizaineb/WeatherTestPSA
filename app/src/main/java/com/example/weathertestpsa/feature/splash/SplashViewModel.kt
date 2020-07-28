package com.example.weathertestpsa.feature.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

/**
 * Created by zaineb on 28/07/2020
 */
class SplashViewModel : ViewModel(), SplashContract.SplashViewModelContract {


    ///////////////////////////////////////////////////////////////////////////
    // LIVEDATA OBSERVATION SECTION
    ///////////////////////////////////////////////////////////////////////////

    private var closingEvent: MutableLiveData<Boolean> = MutableLiveData()
    override fun observeGoToHomeAndClose(): LiveData<Boolean> = closingEvent


    ///////////////////////////////////////////////////////////////////////////
    // INIT SECTION
    ///////////////////////////////////////////////////////////////////////////

    init {
        observeDelay()
    }

    override fun observeDelay() {
        viewModelScope.launch {
            delay(SPLASHSCREEN_DELAY)
            closingEvent.postValue(true)
        }
    }

    companion object {
        private const val SPLASHSCREEN_DELAY: Long = 2000
    }


}