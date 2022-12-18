package com.example.studenthardlife

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.studenthardlife.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            (activity as MainActivity).currentExerciseIndex = it.getInt("currentExerciseIndex")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.exerciseInfo.text = Editable.Factory.getInstance().newEditable(
            (activity as MainActivity).exercises[(activity as MainActivity).currentExerciseIndex].info
        )
        binding.saveButton.setOnClickListener {
            (activity as MainActivity).exercises[(activity as MainActivity).currentExerciseIndex].info =
                binding.exerciseInfo.text.toString()
        }
        binding.deleteButton.setOnClickListener {
            (activity as MainActivity).exercises.removeAt((activity as MainActivity).currentExerciseIndex)
        }
    }

}