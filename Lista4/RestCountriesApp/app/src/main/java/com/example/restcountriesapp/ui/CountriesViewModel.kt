package com.example.restcountriesapp.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.restcountriesapp.model.Country
import com.example.restcountriesapp.model.CountryResponse
import com.example.restcountriesapp.repository.CountryRepository
import com.example.restcountriesapp.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class CountriesViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: CountryRepository = CountryRepository()
    private val _countryList: MutableLiveData<Resource<CountryResponse>> = MutableLiveData()
    private val _country: MutableLiveData<Resource<Country>> = MutableLiveData()

    val countryList: LiveData<Resource<CountryResponse>>
        get() = _countryList

    private fun handleCountryResponse(response: Response<CountryResponse>): Resource<CountryResponse> {
        if (response.isSuccessful) {
            response.body()?.let { return Resource.Success(it) }
        }
        return Resource.Error(response.message())
    }

    fun getCountryList() = viewModelScope.launch {
        _countryList.postValue(Resource.Loading())
        val response = repository.getCountries()
        _countryList.postValue(handleCountryResponse(response))
    }

}