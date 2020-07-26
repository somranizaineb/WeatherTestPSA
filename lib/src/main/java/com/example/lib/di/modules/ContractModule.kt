package com.example.lib.di.modules

import com.example.lib.data.local.dataSource.WeatherLocal
import com.example.lib.data.remote.dataSource.WeatherRemote
import com.example.lib.data.repository.WeatherRepositoryImpl
import com.example.lib.data.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by zaineb on 24/07/2020
 */
@Module
class ContractModule {

    @Provides
    @Singleton
    fun provideWeatherRepository(weatherRemote: WeatherRemote, weatherLocal: WeatherLocal)
            : WeatherRepository = WeatherRepositoryImpl(weatherRemote, weatherLocal)
}