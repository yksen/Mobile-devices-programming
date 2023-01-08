package com.example.restcountriesapp.model

class CountryResponse : ArrayList<Country>()

data class Country(
    val capital: List<String>,
    val flags: Flags,
    val name: Name
)

data class Flags(
    val png: String
)

data class Name(
    val common: String
)