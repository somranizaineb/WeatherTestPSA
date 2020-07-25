package com.example.psatest.data.remote.service

import android.annotation.SuppressLint
import okhttp3.*
import java.io.IOException

/**
 * Created by zaineb on 23/07/2020
 */
class RequestInterceptor : Interceptor {

    var token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJzaG9weXRfa2V5IiwiYXVkIjoiaHR0cDpcL1wvc2hvcHl0LmNvbSIsImlhdCI6MTU1Nzc0MzUwNCwibmJmIjoxNTU3NzQzNTA5LCJleHAiOjE1NTc4Mjk5MDQsImRhdGEiOnsiZW1haWwiOiJhbW5hLmJlbGhhc3NlbkBkaWdpdC11LmNvbSJ9fQ._BnIIfLHJJnaTmNpnt95Mh4wEN8yOIuLPUVIqjm1ILc"
    @SuppressLint("LogConditional")
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val language = "fr"
        val request = chain.request()
        val headers = provideHeaders(token)
        val httpUrl = provideHttpUrl(request, language)
        val newRequest = provideRequest(request, headers, httpUrl)
        return chain.proceed(newRequest)
    }

    companion object {

        /* Headers */
        private const val AUTHORIZATION = "Authorization"

        private fun provideRequest(original: Request, headers: Headers, httpUrl: HttpUrl): Request {
            val requestBuilder = original.newBuilder()
                .headers(headers)
                .url(httpUrl)
                .method(original.method, original.body)
            return requestBuilder.build()
        }

        /**
         * Provide headers with token as authorisation
         *
         * @param token the token
         * @return the headers
         */
        fun provideHeaders(token: String): Headers {
            val headersBuilder = Headers.Builder()
            headersBuilder.add(AUTHORIZATION, token)
            return headersBuilder.build()
        }

        private fun provideHttpUrl(original: Request, languageCode: String): HttpUrl {
            val httpUrlBuilder = original.url.newBuilder()
            httpUrlBuilder.addQueryParameter("lang", languageCode)
            return httpUrlBuilder.build()
        }
    }
}