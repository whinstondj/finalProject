package com.example.finalproject.data.quote.model

class ResponseQuoteDataModel : ArrayList<ResponseQuoteDataModelItem>()

data class ResponseQuoteDataModelItem(
    val a: String,
    val h: String,
    val q: String
)