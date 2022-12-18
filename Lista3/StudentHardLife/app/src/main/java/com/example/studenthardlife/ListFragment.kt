package com.example.studenthardlife

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.studenthardlife.databinding.FragmentListBinding

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val exercises: MutableList<Exercise> = getExercisesList(requireContext()).toMutableList()
        binding.exerciseRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = ExerciseAdapter(exercises)
        }

        binding.addButton.setOnClickListener {
            if (binding.editTitleText.text?.isNotEmpty() == true) {
                exercises.add(
                    Exercise(
                        binding.editTitleText.text.toString(),
                        "Info\nabout\nexercise",
                        ""
                    )
                )
                saveExercisesList(requireContext(), exercises)
                binding.exerciseRecyclerView.adapter?.notifyDataSetChanged()
                binding.editTitleText.text?.clear()
            }
        }
    }

}