package com.example.restcountriesapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.restcountriesapp.databinding.FragmentCapitalsBinding
import com.example.restcountriesapp.model.Country

class CapitalsFragment : Fragment() {
    private lateinit var binding: FragmentCapitalsBinding

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

        binding.capitalsRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = CountryAdapter(listOf(Country("Name", "Capital", "Flag")), false)
        }
    }
}