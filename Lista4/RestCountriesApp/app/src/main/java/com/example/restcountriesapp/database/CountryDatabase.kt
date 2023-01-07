package com.example.restcountriesapp.database

import androidx.room.Database
import androidx.room.Room
import android.content.Context
import androidx.room.RoomDatabase
import com.example.restcountriesapp.model.Country

@Database(entities = [Country::class], version = 1, exportSchema = false)
abstract class CountryDatabase : RoomDatabase() {
    abstract fun countryDAO(): CountryDAO

    companion object {
        @Volatile
        private var INSTANCE: CountryDatabase? = null

        fun getDatabase(context: Context): CountryDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CountryDatabase::class.java,
                    "country_database"
                ).build().also { INSTANCE = it }
                instance
            }
        }
    }
}