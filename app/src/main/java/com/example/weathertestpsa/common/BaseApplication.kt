package com.example.weathertestpsa.common

import android.app.Application
import android.content.Context
import com.example.lib.di.component.DaggerLibComponent
import com.example.lib.di.component.LibComponent
import com.example.lib.di.modules.ContextModule
import com.example.weathertestpsa.di.AppComponent
import com.example.weathertestpsa.di.DaggerAppComponent

/**
 * Created by zaineb on 24/07/2020
 */
class BaseApplication : Application() {

    lateinit var libComponent: LibComponent
    lateinit var component: AppComponent


    companion object {

        /**
         * Obtain lib dagger component.
         *
         * @param context The application context
         */
        @JvmStatic
        fun libComponent(context: Context) =
            (context.applicationContext as? BaseApplication)?.libComponent


        @JvmStatic
        fun component(context: Context) = (context.applicationContext as? BaseApplication)?.component


    }

    override fun onCreate() {
        super.onCreate()
        initCoreDependencyInjection()
        initAppDependencyInjection()
    }

    ///////////////////////////////////////////////////////////////////////////
    // Private init methods
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Initialize app dependency injection component.
     */
    private fun initAppDependencyInjection() {
        component = DaggerAppComponent
            .builder()
            .libComponent(libComponent)
            .build()

        component.inject(this)
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
