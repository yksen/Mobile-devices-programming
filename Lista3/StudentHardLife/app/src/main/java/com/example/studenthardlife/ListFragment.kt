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
        binding.exerciseRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.exerciseRecyclerView.adapter = ExerciseAdapter((activity as MainActivity).exercises)
        binding.addButton.setOnClickListener {
            if (binding.editTitleText.text?.isNotEmpty() == true) {
                (activity as MainActivity).exercises.add(
                    Exercise(
                        binding.editTitleText.text.toString(),
                        "Description"
                    )
                )
                binding.exerciseRecyclerView.adapter?.notifyDataSetChanged()
                binding.editTitleText.text?.clear()
            }
        }
    }

}