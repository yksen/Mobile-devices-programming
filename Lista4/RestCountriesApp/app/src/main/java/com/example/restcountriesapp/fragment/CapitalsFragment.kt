package com.example.restcountriesapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.restcountriesapp.databinding.FragmentCapitalsBinding

class CapitalsFragment : Fragment() {
    private lateinit var binding: FragmentCapitalsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCapitalsBinding.inflate(inflater, container, false)
        return binding.root
    }
}