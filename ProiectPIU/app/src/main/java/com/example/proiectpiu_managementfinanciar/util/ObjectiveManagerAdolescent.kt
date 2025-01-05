package com.example.proiectpiu_managementfinanciar.util

import com.example.proiectpiu_managementfinanciar.models.Objective

object ObjectiveManagerAdolescent {
    private val objectiveList: MutableList<Objective> = mutableListOf(
        Objective("Bicicletă", 500.0, 1000.0, "Bicicletă"),
        Objective("Skateboard", 150.0, 400.0, "Skateboard"),
        Objective("Smartphone", 700.0, 1200.0, "Smartphone")
    )

    fun addObjective(objective: Objective) {
        objectiveList.add(objective)
    }

    fun getObjectives(): List<Objective> = objectiveList
}
