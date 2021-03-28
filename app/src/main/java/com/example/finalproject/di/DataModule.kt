package com.example.finalproject.di


import com.example.finalproject.data.config.QuoteDatabase
import com.example.finalproject.data.config.QuoteRetrofit
import com.example.finalproject.data.quote.repository.QuoteRepositoryImpl
import com.example.finalproject.data.quote.repository.local.QuoteLocal
import com.example.finalproject.data.quote.repository.network.QuoteNetwork
import com.example.finalproject.data.quote.repository.network.QuoteService
import com.example.finalproject.domain.repository.QuoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)

object DataModule {
    @Provides
    fun provideQuoteRepository (retrofit: QuoteRetrofit, quotesDatabase: QuoteDatabase): QuoteRepository = QuoteRepositoryImpl(QuoteNetwork(retrofit.loadRetrofit().create(QuoteService::class.java)),
        QuoteLocal(quotesDatabase.loadDatabase().quoteDao())
    )
}
//val dataModule = module {
//    factory {
//        provideQuoteRepository(get())
//    }

//    single {
//        provideRetrofit(androidContext())
//    }
//}

//fun provideRetrofit(context: Context):Retrofit {
//    return QuoteRetrofit(NetworkManager(context)).loadRetrofit()

//}