package com.example.restcountriesapp.api

import com.example.restcountriesapp.model.Country
import com.example.restcountriesapp.model.CountryResponse
import retrofit2.Response
import retrofit2.http.GET

interface CountryApi {
    @GET("v3.1/all")
    suspend fun getCountries(): Response<CountryResponse>
}