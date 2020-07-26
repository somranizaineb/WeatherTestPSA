package com.example.weathertestpsa.common.base

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.weathertestpsa.common.viewModel.ViewModelFactory
import javax.inject.Inject

/**
 * Created by zaineb on 24/07/2020
 */
abstract class BaseActivity :
    AppCompatActivity(){

    ///////////////////////////////////////////////////////////////////////////
    // VIEWMODEL FACTORY INJECTION
    ///////////////////////////////////////////////////////////////////////////
    @Inject
    lateinit var viewModelFactory: ViewModelFactory


    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // LIFE CYCLE
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        BaseApplication.component(
            this
        )?.inject(this)
    }

    ///////////////////////////////////////////////////////////////////////////
    // VIEWMODEL ACTIVITY EXTENTION
    ///////////////////////////////////////////////////////////////////////////
    inline fun <reified T : ViewModel> AppCompatActivity.viewModel(): T =
        ViewModelProvider(this, viewModelFactory).get(T::class.java)

}