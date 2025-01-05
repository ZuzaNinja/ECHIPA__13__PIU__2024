package com.example.proiectpiu_managementfinanciar.util

import com.example.proiectpiu_managementfinanciar.R
import com.example.proiectpiu_managementfinanciar.models.Objective

object ObjectiveManager {
    val objectiveList: MutableList<Objective> = mutableListOf(
        Objective("Mașină", 10000.0, 25000.0, R.drawable.car_icon1),
        Objective("Căști", 150.0, 490.0, R.drawable.headphones_icon2),
        Objective("Adidași", 300.0, 560.0, R.drawable.sneakers_icon3)
    )

    fun addObjective(objective: Objective) {
        objectiveList.add(objective)
    }

    fun getObjectives(): List<Objective> {
        return objectiveList.toList()
    }
}

