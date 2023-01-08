package com.example.restcountriesapp.repository

import com.example.restcountriesapp.api.RetrofitInstance

class CountryRepository {
    suspend fun getCountries() = RetrofitInstance.api.getCountries()
}