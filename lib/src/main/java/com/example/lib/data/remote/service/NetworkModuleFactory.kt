package com.example.lib.data.remote.service

import android.app.Application
import android.content.Context
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.net.CookieManager
import java.net.CookiePolicy
import java.util.concurrent.TimeUnit
import javax.inject.Named

/**
 * Created by zaineb on 23/07/2020
 */
object NetworkModuleFactory {

    const val CONNECT_TIMEOUT: Long = 60 // 10MB
    const val READ_TIMEOUT: Long = 60 // 10MB
    const val LOG_INTERCEPTOR = "LogInterceptor"
    const val CACHE = "cache"

    fun makeService(context: Context): ServiceEndPoint =
        makeService(makeOkHttpClient(context))

    private fun makeService(okHttpClient: OkHttpClient): ServiceEndPoint {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient)
            .build()

        return retrofit.create(ServiceEndPoint::class.java)
    }

    private fun makeOkHttpClient(context: Context): OkHttpClient {

        val cookieManager = CookieManager()
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL)

        return OkHttpClient.Builder()
            .addInterceptor(provideLogInterceptor())
            .cache(provideCache(context as Application))
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .build()
    }

    @Named(LOG_INTERCEPTOR)
    internal fun provideLogInterceptor(): Interceptor {
        val logInterceptor = HttpLoggingInterceptor()
        logInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return logInterceptor
    }


    @Named(CACHE)
    internal fun provideCache(application: Application): Cache {
        val cacheSize = 10 * 1024 * 1024 // 10MB
        return Cache(application.cacheDir, cacheSize.toLong())

    }


}