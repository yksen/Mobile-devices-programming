package com.example.restcountriesapp.fragment

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.restcountriesapp.R
import com.example.restcountriesapp.model.Country

class CountryAdapter(private val countries: List<Country>, val showFlags: Boolean) :
    RecyclerView.Adapter<CountryAdapter.ListViewHolder>() {

    class ListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val countryName: TextView = itemView.findViewById(R.id.countryName)
        val countryCapital: TextView = itemView.findViewById(R.id.countryCapital)
        val countryFlag: ImageView = itemView.findViewById(R.id.countryFlag)
    }

    override fun getItemCount(): Int {
        return countries.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val country = countries[position]
        holder.countryName.text = country.name
        holder.countryCapital.text = country.capital

        if (showFlags) {
            holder.countryFlag.visibility = View.VISIBLE
            holder.countryCapital.visibility = View.GONE
        } else {
            holder.countryFlag.visibility = View.GONE
            holder.countryCapital.visibility = View.VISIBLE
        }
    }
}