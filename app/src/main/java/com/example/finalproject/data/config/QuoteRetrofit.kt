package com.example.finalproject.data.config

import com.example.finalproject.BuildConfig
import com.example.finalproject.base.exception.NoInternetException
import com.example.finalproject.base.util.NetworkManager
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class QuoteRetrofit(private val networkManager: NetworkManager) {

    fun loadRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://zenquotes.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(createHttpClient())
            .build()
    }

    private fun createHttpClient(): OkHttpClient {
        // Create OkHttpClient
        val builder = OkHttpClient.Builder()
            .connectTimeout(90L, TimeUnit.SECONDS)
            .readTimeout(90L, TimeUnit.SECONDS)
            .writeTimeout(90L, TimeUnit.SECONDS)

        // Logger interceptor
        val loggerInterceptor = HttpLoggingInterceptor()
        loggerInterceptor.level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        builder.addInterceptor(loggerInterceptor)

        // Check internet connectivity
        val checkInternetConnectivityInterceptor = Interceptor {
            if (!networkManager.isNetworkAvailable()) {
                throw NoInternetException()
            }
            it.proceed(it.request())
        }
        builder.addInterceptor(checkInternetConnectivityInterceptor)


        //Request
        builder.addInterceptor { chain ->
            var request = chain.request()
            val url = request.url.newBuilder()
                .build()
            request = request.newBuilder().url(url).build()
            chain.proceed(request)
        }

        return builder.build()
    }

}