package com.example.finalproject.data.config.network

import com.example.finalproject.BuildConfig
import com.example.finalproject.data.quote.model.ResponseQuoteDataModel
import com.example.finalproject.data.quote.model.ResponseQuoteDataModelItem
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class QuoteNetwork {
    lateinit var service: QuoteService

    private fun loadRetrofit() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://zenquotes.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(createHttpClient())
            .build()


        service = retrofit.create(QuoteService::class.java)
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

        builder.addInterceptor { chain ->
            var request = chain.request()
            val url = request.url.newBuilder()
                .build()
            request = request.newBuilder().url(url).build()
            chain.proceed(request)
        }

        return builder.build()
    }

    suspend fun getFiftyQuotes(): ResponseQuoteDataModel {
        loadRetrofit()
        return service.getFiftyQuotes()
    }

    suspend fun getTodayQuote(): List<ResponseQuoteDataModelItem> {
        loadRetrofit()
        return service.getTodayQuote()
    }

    suspend fun getRandomQuote(): List<ResponseQuoteDataModelItem> {
        loadRetrofit()
        return service.getRandomQuote()
    }
}