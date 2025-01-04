package com.example.proiectpiu_managementfinanciar.util

import com.example.proiectpiu_managementfinanciar.models.Objective

object ObjectiveManager {
    val objectiveList: MutableList<Objective> = mutableListOf(
        Objective("Mașină", 10000.0, 25000.0, "Mașină"),
        Objective("Căști", 150.0, 490.0, "Căști"),
        Objective("Adidași", 300.0, 560.0, "Adidași")
    )

    fun addObjective(objective: Objective) {
        objectiveList.add(objective)
    }

    fun getObjectives(): List<Objective> {
        return objectiveList.toList()
    }
}

