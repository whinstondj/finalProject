package com.example.finalproject.domain.model

import java.io.Serializable

data class QuoteDomainModel (
    val id: Int = 0,
    val author: String = "",
    val quote: String = ""
): Serializable