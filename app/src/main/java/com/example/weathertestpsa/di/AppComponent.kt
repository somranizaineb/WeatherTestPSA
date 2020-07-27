package com.example.weathertestpsa.di

import com.example.lib.di.component.AppScope
import com.example.lib.di.component.LibComponent
import com.example.weathertestpsa.feature.weather.MainActivity
import com.example.weathertestpsa.common.base.BaseApplication
import com.example.weathertestpsa.di.module.AppModule
import com.example.weathertestpsa.di.module.ViewModelModule
import com.example.weathertestpsa.feature.weather.WeatherViewModel
import dagger.Component

/**
 * Created by zaineb on 24/07/2020
 */
@AppScope
@Component(
    dependencies = [LibComponent::class],
    modules = [AppModule::class,ViewModelModule::class]
)
interface AppComponent {

    /**
     * Inject dependencies on application.
     *
     * @param application The sample application.
     */
    fun inject(application: BaseApplication)

    fun inject(mainActivity: MainActivity)

    fun inject(weatherViewModel: WeatherViewModel)
}
