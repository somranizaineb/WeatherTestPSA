package com.example.lib.di.component

import android.content.Context
import com.example.lib.data.local.AppDatabase
import com.example.lib.di.modules.ContextModule
import com.example.lib.di.modules.ContractModule
import com.example.lib.di.modules.DatabaseModule
import com.example.lib.di.modules.NetworkModule
import com.example.lib.data.remote.service.ServiceEndPoint
import com.example.lib.data.repository.WeatherRepository
import dagger.Component
import javax.inject.Singleton

/**
 * Created by zaineb on 24/07/2020
 */
@Singleton
@Component(
    modules = [
        ContextModule::class,
        NetworkModule::class,
        DatabaseModule::class,
        ContractModule::class
    ]
)
interface LibComponent {

    fun context(): Context

    /**
     * Provide dependency graph MarvelRepository
     *
     * @return MarvelRepository
     */
    fun serviceEndPoint(): ServiceEndPoint

    /**
     * Provide dependency graph CharacterFavoriteDao
     *
     * @return CharacterFavoriteDao
     */
    fun appDatabase(): AppDatabase

    /**
     * Provide dependency graph ThemeUtils
     *
     * @return ThemeUtils
     */
    fun weatherRepository(): WeatherRepository


}
