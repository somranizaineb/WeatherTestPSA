package com.example.weathertestpsa.common.base

import android.app.Application
import com.example.lib.di.component.DaggerLibComponent
import com.example.lib.di.component.LibComponent
import com.example.lib.di.modules.ContextModule
import com.example.weathertestpsa.di.AppComponent
import com.example.weathertestpsa.di.DaggerAppComponent

/**
 * Created by zaineb on 24/07/2020
 */
class BaseApplication : Application() {

    ///////////////////////////////////////////////////////////////////////////
    // COMPANION OBJECT SECTION
    ///////////////////////////////////////////////////////////////////////////
    companion object {

        /**
         * Obtain app  components.
         * libComponent and appComponent
         */
        lateinit var libComponent: LibComponent
        lateinit var appComponent: AppComponent



    }

    override fun onCreate() {
        super.onCreate()
        initCoreDependencyInjection()
        initAppDependencyInjection()
    }

    ///////////////////////////////////////////////////////////////////////////
    // PRIVATE INIT METHODS
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Initialize app dependency injection component.
     */
    private fun initAppDependencyInjection() {
        appComponent = DaggerAppComponent
            .builder()
            .libComponent(libComponent)
            .build()

        appComponent.inject(this)
    }

    /**
     * Initialize core dependency injection component.
     */
    private fun initCoreDependencyInjection() {
        libComponent = DaggerLibComponent
            .builder()
            .contextModule(ContextModule(this))
            .build()
    }

}
