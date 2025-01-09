package com.example.proiectpiu_managementfinanciar.util

import android.content.Context
import com.example.proiectpiu_managementfinanciar.R
import com.example.proiectpiu_managementfinanciar.models.Objective

object ObjectiveManagerAdolescent {
    private val objectiveList: MutableList<Objective> = mutableListOf()

    fun initialize(context: Context) {
        objectiveList.clear()
        objectiveList.addAll(
            listOf(
                Objective(context.getString(R.string.objective_bicycle), 500.0, 1000.0, R.drawable.bicycle_icon6),
                Objective(context.getString(R.string.objective_skateboard), 150.0, 400.0, R.drawable.skateboard_icon14),
                Objective(context.getString(R.string.objective_smartphone), 700.0, 1200.0, R.drawable.smartphone_icon4)
            )
        )
    }

    fun addObjective(objective: Objective) {
        objectiveList.add(objective)
    }

    fun getObjectives(): List<Objective> = objectiveList
}
