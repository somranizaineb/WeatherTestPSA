package com.example.weathertestpsa.di.module

import android.content.Context
import com.example.lib.di.component.AppScope
import com.example.weathertestpsa.common.BaseApplication
import dagger.Module
import dagger.Provides

/**
 * Created by zaineb on 24/07/2020
 */
@Module
class AppModule {

    @AppScope
    @Provides
    fun provideContext(application: BaseApplication): Context = application.applicationContext
}