package com.example.weathertestpsa.di

import com.example.lib.di.component.AppScope
import com.example.lib.di.component.LibComponent
import com.example.weathertestpsa.feature.weather.WeatherActivity
import com.example.weathertestpsa.common.base.BaseApplication
import com.example.weathertestpsa.di.module.AppModule
import com.example.weathertestpsa.feature.splash.SplashViewModel
import com.example.weathertestpsa.feature.weather.WeatherViewModel
import dagger.Component

/**
 * Created by zaineb on 24/07/2020
 */
@AppScope
@Component(
    dependencies = [LibComponent::class],
    modules = [AppModule::class]
)
interface AppComponent {

    fun inject(application: BaseApplication)
    fun inject(weatherActivity: WeatherActivity)
    fun inject(weatherViewModel: WeatherViewModel)
    fun inject(splashViewModel: SplashViewModel)
}
