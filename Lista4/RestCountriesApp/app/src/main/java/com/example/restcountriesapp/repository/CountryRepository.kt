package com.example.restcountriesapp.repository

import androidx.lifecycle.LiveData
import com.example.restcountriesapp.api.RetrofitInstance
import com.example.restcountriesapp.database.CountryDAO
import com.example.restcountriesapp.model.Country

class CountryRepository(private val countryDAO: CountryDAO) {
    val readAllData: LiveData<List<Country>> = countryDAO.getAllCountries()

    suspend fun getCountries() = RetrofitInstance.api.getCountries()
    suspend fun insert(country: Country) = countryDAO.insert(country)
}