package com.example.finalproject.data.quote.repository.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.finalproject.data.quote.model.QuoteEntityDataModel

@Dao
interface QuoteDAO {
    @Query("SELECT * FROM quotes")
    suspend fun getAllSavedQuotes(): List<QuoteEntityDataModel>

    @Insert
    suspend fun insertNewQuote(quote: QuoteEntityDataModel)

    @Delete
    suspend fun deleteSavedQuote(quote: QuoteEntityDataModel)


}