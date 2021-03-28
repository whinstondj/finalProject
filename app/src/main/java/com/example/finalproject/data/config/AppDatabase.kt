package com.example.finalproject.data.config

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.finalproject.data.quote.model.QuoteEntityDataModel

@Database(entities = [QuoteEntityDataModel::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun quoteDao(): QuoteDAO
}