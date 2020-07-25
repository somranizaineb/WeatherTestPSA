package com.example.weathertestpsa.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.lib.di.component.AppScope
import com.example.weathertestpsa.common.ViewModelFactory
import com.example.weathertestpsa.common.ViewModelKey
import com.example.weathertestpsa.feature.viemModel.WeatherViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by zaineb on 24/07/2020
 */
@Module
abstract class ViewModelModule {

    @AppScope
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @AppScope
    @Binds
    @IntoMap
    @ViewModelKey(WeatherViewModel::class)
    abstract fun bindsWeatherViewModel(weatherViewModel: WeatherViewModel): ViewModel
}