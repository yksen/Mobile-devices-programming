package com.example.restcountriesapp.ui.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.restcountriesapp.databinding.ItemCountryBinding
import com.example.restcountriesapp.model.Country

class CountryAdapter(countryComparator: CountryComparator, private val showFlags: Boolean) :
    ListAdapter<Country, CountryAdapter.CountryViewHolder>(countryComparator) {

    class CountryViewHolder(private val binding: ItemCountryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(country: Country, showFlags: Boolean) {
            binding.apply {
                countryName.text = country.name.common
                countryCapital.text =
                    if (country.capital.isNotEmpty()) country.capital.first() else "No capital"
                if (showFlags) {
                    Glide.with(binding.root)
                        .load(country.flags.png)
                        .into(countryFlag)
                    countryFlag.visibility = View.VISIBLE
                    countryCapital.visibility = View.GONE
                } else {
                    countryFlag.visibility = View.GONE
                    countryCapital.visibility = View.VISIBLE
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        return CountryViewHolder(
            ItemCountryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = getItem(position)
        holder.bind(country, showFlags)
    }
}