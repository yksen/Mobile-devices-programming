package com.example.restcountriesapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.restcountriesapp.databinding.FragmentFlagsBinding
import com.example.restcountriesapp.model.Country

class FlagsFragment : Fragment() {
    private lateinit var binding: FragmentFlagsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFlagsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.flagsRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = CountryAdapter(listOf(Country("Name", "Capital", "Flag")), true)
        }
    }
}