package com.example.restcountriesapp.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.restcountriesapp.databinding.FragmentCapitalsBinding
import com.example.restcountriesapp.model.Country
import com.example.restcountriesapp.ui.CountriesViewModel
import com.example.restcountriesapp.util.Resource

class CapitalsFragment : Fragment() {
    private lateinit var binding: FragmentCapitalsBinding
    private val countriesViewModel: CountriesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCapitalsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        countriesViewModel.getCountryList()
        val adapter = CountryAdapter(CountryComparator(), false)
        binding.capitalsRecyclerView.apply {
            this.adapter = adapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        observeCountries(adapter)
    }

    private fun observeCountries(countryAdapter: CountryAdapter) {
        countriesViewModel.countryList.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Success -> {
                    response.data?.let { countryList ->
                        countryAdapter.submitList(countryList)
                    }
                }
                is Resource.Error -> {
                    response.message?.let { Log.e("CapitalsFragment", it) }
                }
                is Resource.Loading -> {
                    Log.d("CapitalsFragment", "Loading")
                }
            }
        }
    }
}