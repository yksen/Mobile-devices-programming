package com.example.studentcrime

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class CrimeAdapter : RecyclerView.Adapter<CrimeAdapter.CrimeViewHolder>() {

    private val crimeList: List<Crime> = Crimes.crimes

    class CrimeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val crimeTitle: TextView = itemView.findViewById(R.id.crimeTitleView)
        val crimeIsSolved: ImageView = itemView.findViewById(R.id.crimeIsSolvedView)
    }

    override fun getItemCount() = crimeList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrimeViewHolder {
        return CrimeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_crime, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CrimeViewHolder, position: Int) {
        val crime = crimeList[position]
        holder.crimeTitle.text = crime.title
        holder.crimeIsSolved.visibility = if (crime.isSolved) View.VISIBLE else View.INVISIBLE
        holder.itemView.setOnClickListener {
            val crimeInfo = String.format(
                "%s\n%s\nCommitted by student with the index %d\nThe crime is currently%s solved",
                crime.title,
                crime.description,
                crime.studentIndex,
                if (crime.isSolved) "" else " not"
            )
            val action = ListFragmentDirections.actionListFragmentToDetailFragment(crimeInfo)
            holder.itemView.findNavController().navigate(action)
        }
    }

}