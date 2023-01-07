package com.example.restcountriesapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.restcountriesapp.model.Country

@Dao
interface CountryDAO {
    @Insert(onConflict = REPLACE)
    suspend fun insert(country: Country)

    @Query("SELECT * FROM countries")
    fun getAllCountries(): LiveData<List<Country>>
}