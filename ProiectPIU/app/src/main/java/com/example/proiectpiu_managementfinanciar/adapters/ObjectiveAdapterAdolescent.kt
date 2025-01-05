package com.example.proiectpiu_managementfinanciar.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.proiectpiu_managementfinanciar.R
import com.example.proiectpiu_managementfinanciar.models.Objective

class ObjectiveAdapterAdolescent(
    private var objectives: List<Objective>,
    private val onObjectiveSelected: () -> Unit
) : RecyclerView.Adapter<ObjectiveAdapterAdolescent.ObjectiveViewHolder>() {

    private var selectedPosition: Int = RecyclerView.NO_POSITION
    private var isSelectionLocked: Boolean = false

    inner class ObjectiveViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val objectiveIcon: ImageView = itemView.findViewById(R.id.objectiveIcon)
        val objectiveTitle: TextView = itemView.findViewById(R.id.objectiveTitle)
        val objectiveAmount: TextView = itemView.findViewById(R.id.objectiveAmount)
        val objectiveProgressBar: ProgressBar = itemView.findViewById(R.id.objectiveProgressBar)
        val completedCheckIcon: ImageView = itemView.findViewById(R.id.completedCheckIcon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ObjectiveViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.objective_item_activity, parent, false)
        return ObjectiveViewHolder(view)
    }

    override fun onBindViewHolder(holder: ObjectiveViewHolder, @SuppressLint("RecyclerView") position: Int) {
        val objective = objectives[position]
        holder.objectiveTitle.text = objective.denumire
        holder.objectiveAmount.text = "${objective.sumaCurenta} RON / ${objective.sumaTotala} RON"

        val progressPercentage = if (objective.sumaTotala > 0) {
            (objective.sumaCurenta / objective.sumaTotala * 100).toInt()
        } else {
            0
        }
        holder.objectiveProgressBar.progress = progressPercentage

        when (objective.iconita) {
            "Mașină" -> holder.objectiveIcon.setImageResource(R.drawable.car_icon1)
            "Căști" -> holder.objectiveIcon.setImageResource(R.drawable.headphones_icon2)
            "Adidași" -> holder.objectiveIcon.setImageResource(R.drawable.sneakers_icon3)
            "Smartphone" -> holder.objectiveIcon.setImageResource(R.drawable.smartphone_icon4)
            "Tabletă" -> holder.objectiveIcon.setImageResource(R.drawable.tablet_icon5)
            "Bicicletă" -> holder.objectiveIcon.setImageResource(R.drawable.bicycle_icon6)
            "Schi" -> holder.objectiveIcon.setImageResource(R.drawable.ski_icon7)
            "Role" -> holder.objectiveIcon.setImageResource(R.drawable.roller_skate_icon8)
            "Vacanță" -> holder.objectiveIcon.setImageResource(R.drawable.vacation_icon9)
            "Concert" -> holder.objectiveIcon.setImageResource(R.drawable.concert_icon10)
            else -> holder.objectiveIcon.setImageResource(R.drawable.object_icon)
        }


        if (objective.sumaCurenta >= objective.sumaTotala) {
            holder.completedCheckIcon.visibility = View.VISIBLE
        } else {
            holder.completedCheckIcon.visibility = View.GONE
        }

        if (selectedPosition == position) {
            holder.itemView.setBackgroundResource(R.drawable.selected_objective_border)
        } else {
            holder.itemView.setBackgroundResource(R.drawable.objective_card_background)
        }

        holder.itemView.setOnClickListener {
            if (objective.sumaCurenta >= objective.sumaTotala) {
                Toast.makeText(holder.itemView.context, "Obiectiv deja atins!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!isSelectionLocked) {
                val previousPosition = selectedPosition
                selectedPosition = position

                notifyItemChanged(previousPosition)
                notifyItemChanged(selectedPosition)

                onObjectiveSelected()
            }
        }

    }

    override fun getItemCount(): Int = objectives.size

    fun getSelectedPosition(): Int {
        return selectedPosition
    }

    fun unlockSelection() {
        isSelectionLocked = false
        notifyItemChanged(selectedPosition)
        selectedPosition = RecyclerView.NO_POSITION
    }

    fun updateObjectives(newObjectives: List<Objective>) {
        objectives = newObjectives
        notifyDataSetChanged()
    }
}
