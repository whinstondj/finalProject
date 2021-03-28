package com.example.finalproject.data.quote.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.finalproject.domain.model.QuoteDomainModel

@Entity(tableName = "quotes")
data class QuoteEntityDataModel(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    @ColumnInfo(name = "author") val author: String,
    @ColumnInfo(name = "quote") val quote: String
)

fun QuoteEntityDataModel.toDomainModel(): QuoteDomainModel {
    return QuoteDomainModel (uid, author,quote)
}

fun QuoteDomainModel.toDataModel(): QuoteEntityDataModel {
    return QuoteEntityDataModel(id, author,quote)
}