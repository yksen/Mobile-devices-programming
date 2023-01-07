package com.example.restcountriesapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "countries")
data class Country(
    @PrimaryKey
    val name: String,
    val capital: String,
    val flag: String
)