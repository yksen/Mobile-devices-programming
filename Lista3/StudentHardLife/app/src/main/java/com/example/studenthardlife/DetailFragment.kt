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
    private var currentExerciseIndex: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            currentExerciseIndex = it.getInt("currentExerciseIndex")
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
        super.onViewCreated(view, savedInstanceState)

        val exercises: MutableList<Exercise> = getExerciseList(requireContext()).toMutableList()

        binding.exerciseInfo.text = Editable.Factory.getInstance().newEditable(
            exercises[currentExerciseIndex].info
        )
        binding.saveButton.setOnClickListener {
            exercises[currentExerciseIndex].info = binding.exerciseInfo.text.toString()
            saveExerciseList(requireContext(), exercises)
        }
        binding.deleteButton.setOnClickListener {
            exercises.removeAt(currentExerciseIndex)
            saveExerciseList(requireContext(), exercises)
        }
    }

}