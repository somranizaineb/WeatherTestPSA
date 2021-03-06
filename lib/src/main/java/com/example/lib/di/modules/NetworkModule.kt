package com.example.lib.di.modules
import android.content.Context
import com.example.lib.data.remote.service.NetworkModuleFactory
import com.example.lib.data.remote.service.ServiceEndPoint
import dagger.Module
import dagger.Provides


/**
 * Created by zaineb on 23/07/2020
 */
@Module
class NetworkModule {

    /**
     * Create a provider method binding for [ServiceEndPoint].
     *
     * @return Instance of ServiceEndPoint.
     * @see Provides
     */
    @Provides
    internal fun provideServiceEndPoint(context: Context): ServiceEndPoint =
        NetworkModuleFactory.makeService(context)
}
