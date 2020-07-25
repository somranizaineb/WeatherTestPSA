package com.example.weathertestpsa.common

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

/**
 * Created by zaineb on 24/07/2020
 */
abstract class BaseActivity :
    AppCompatActivity(){

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        BaseApplication.component(this)?.inject(this)
    }

    inline fun <reified T : ViewModel> AppCompatActivity.viewModel(): T =
        ViewModelProvider(this, viewModelFactory).get(T::class.java)

}