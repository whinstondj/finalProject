package com.example.finalproject.di

import android.content.Context
import com.example.finalproject.base.util.NetworkManager
import com.example.finalproject.data.config.QuoteRetrofit
import com.example.finalproject.data.quote.repository.QuoteRepositoryImpl
import com.example.finalproject.data.quote.repository.network.QuoteNetwork
import com.example.finalproject.data.quote.repository.network.QuoteService
import com.example.finalproject.domain.repository.QuoteRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit

val dataModule = module {
    factory {
        provideQuoteRepository(get())
    }

    single {
        provideRetrofit(androidContext())
    }
}

fun provideRetrofit(context: Context):Retrofit {
    return QuoteRetrofit(NetworkManager(context)).loadRetrofit()

}

fun provideQuoteRepository(retrofit: Retrofit): QuoteRepository {
    return QuoteRepositoryImpl(QuoteNetwork(retrofit.create(QuoteService::class.java)))
}
