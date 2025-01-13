package com.example.proiectpiu_managementfinanciar.reports

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.proiectpiu_managementfinanciar.R
import com.example.proiectpiu_managementfinanciar.util.ObjectiveManagerAdolescent

class SavingsTeen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_savings_teen)

        // Inițializează obiectivele
        ObjectiveManagerAdolescent.initialize(this)

        val pieChartViewAdolescent = findViewById<CustomPieChart>(R.id.pieChartViewAdolescent)
        val selectedSliceInfoAdolescent = findViewById<TextView>(R.id.selectedSliceInfoAdolescent)
        val totalAmountText = findViewById<TextView>(R.id.totalAmountText)

        // Preia obiectivele
        val objectives = ObjectiveManagerAdolescent.getObjectives()
        if (objectives.isEmpty()) {
            Log.e("SavingsTeen", "Lista de obiective este goală.")
            totalAmountText.text = "Total economii: 0 lei"
            return
        }

        // Date pentru economii
        val adolescentSavings = objectives.map { objective ->
            Triple(
                objective.sumaCurenta.toFloat(),
                objective.denumire,
                objective.sumaTotala
            )
        }

        val colorsAdolescent = listOf(
            Color.parseColor("#C35214"), // alloy_orange
            Color.parseColor("#FBCEB1"), // apricot_orange
            Color.parseColor("#FF9966"), // atomic_tangerine
            Color.parseColor("#FE6F5E"), // bittersweet_orange
            Color.parseColor("#E24C00")  // bright_orange
        )

        // Crează datele pentru grafic
        val dataForChartAdolescent = objectives.mapIndexed { index, objective ->
            Triple(
                objective.sumaCurenta.toFloat(),
                colorsAdolescent[index % colorsAdolescent.size],
                objective.denumire
            )
        }

        // Setează datele pentru grafic
        pieChartViewAdolescent.setData(dataForChartAdolescent)

        // Calculează totalul economiilor
        val totalSavings = objectives.sumOf { it.sumaCurenta }
        totalAmountText.text = "Total economii: %.0f lei".format(totalSavings)

        // Setează listener pentru felia selectată
        pieChartViewAdolescent.setOnSliceSelectedListener { _, slice ->
            val value = slice.first
            val color = slice.second
            val name = slice.third

            val totalSum = dataForChartAdolescent.sumOf { it.first.toDouble() }
            selectedSliceInfoAdolescent.text = String.format(
                "Categorie: %s\nSuma: %.0f lei\nProcent: %.1f%%",
                name,
                value,
                (value / totalSum) * 100
            )
            selectedSliceInfoAdolescent.setTextColor(color)
        }
    }
}
