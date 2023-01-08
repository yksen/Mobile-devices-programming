package com.example.restcountriesapp.ui.fragment

import androidx.recyclerview.widget.DiffUtil
import com.example.restcountriesapp.model.Country

class CountryComparator : DiffUtil.ItemCallback<Country>() {

    override fun areItemsTheSame(oldItem: Country, newItem: Country): Boolean {
        return oldItem.name.common == newItem.name.common
    }

    override fun areContentsTheSame(oldItem: Country, newItem: Country): Boolean {
        return oldItem == newItem
    }
}