package com.example.proiectpiu_managementfinanciar.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proiectpiu_managementfinanciar.R
import com.example.proiectpiu_managementfinanciar.models.Objective

class ObjectiveAdapter(private var objectives: List<Objective>) :
    RecyclerView.Adapter<ObjectiveAdapter.ObjectiveViewHolder>() {

    inner class ObjectiveViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val objectiveIcon: ImageView = itemView.findViewById(R.id.objectiveIcon)
        val objectiveTitle: TextView = itemView.findViewById(R.id.objectiveTitle)
        val objectiveAmount: TextView = itemView.findViewById(R.id.objectiveAmount)
        val objectiveProgressBar: ProgressBar = itemView.findViewById(R.id.objectiveProgressBar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ObjectiveViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.objective_item_activity, parent, false)
        return ObjectiveViewHolder(view)
    }

    override fun onBindViewHolder(holder: ObjectiveViewHolder, position: Int) {
        val objective = objectives[position]
        holder.objectiveTitle.text = objective.denumire
        holder.objectiveAmount.text = "${objective.sumaCurenta} RON / ${objective.sumaTotala} RON"

        // Calculare procentaj progres
        val progressPercentage = if (objective.sumaTotala > 0) {
            (objective.sumaCurenta / objective.sumaTotala * 100).toInt()
        } else {
            0
        }
        holder.objectiveProgressBar.progress = progressPercentage

        // Setarea iconitei
        when (objective.iconita) {
            "Mașină" -> holder.objectiveIcon.setImageResource(R.drawable.car_icon1)
            "Căști" -> holder.objectiveIcon.setImageResource(R.drawable.headphones_icon2)
            "Adidași" -> holder.objectiveIcon.setImageResource(R.drawable.sneakers_icon3)
            else -> holder.objectiveIcon.setImageResource(R.drawable.vacation_icon9)
        }
    }



    override fun getItemCount(): Int = objectives.size

    fun updateObjectives(newObjectives: List<Objective>) {
        objectives = newObjectives
        notifyDataSetChanged()
    }
}
