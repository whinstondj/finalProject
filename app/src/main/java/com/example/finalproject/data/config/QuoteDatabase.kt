package com.example.finalproject.data.config

import android.content.Context
import androidx.room.Room
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class QuoteDatabase @Inject constructor(@ApplicationContext private val context: Context) {
    fun loadDatabase(): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "quotes.db").build()
    }
}