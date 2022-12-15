package com.example.studenthardlife

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class ExerciseListAdapter : RecyclerView.Adapter<ExerciseListAdapter.ListViewHolder>() {

    private val exerciseLists: List<ExerciseList> = ExerciseLists.lists

    class ListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val listTitle: TextView = itemView.findViewById(R.id.listTitle)
    }

    override fun getItemCount(): Int {
        return exerciseLists.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val list = exerciseLists[position]
        holder.listTitle.text = list.title
        holder.itemView.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToDetailFragment()
            holder.itemView.findNavController().navigate(action)
        }
    }

}