package com.example.restcountriesapp.fragment.flags

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.restcountriesapp.databinding.FragmentFlagsBinding

class FlagsFragment : Fragment() {
    private lateinit var binding: FragmentFlagsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFlagsBinding.inflate(inflater, container, false)
        return binding.root
    }
}