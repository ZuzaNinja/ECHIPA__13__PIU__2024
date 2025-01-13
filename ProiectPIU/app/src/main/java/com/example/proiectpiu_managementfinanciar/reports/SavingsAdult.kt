package com.example.proiectpiu_managementfinanciar.reports

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.proiectpiu_managementfinanciar.R
import com.example.proiectpiu_managementfinanciar.util.ObjectiveManager

class SavingsAdult : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_savings_adult)

        // Inițializăm ObjectiveManager
        ObjectiveManager.init(this)

        val pieChartView = findViewById<CustomPieChart>(R.id.pieChartView)
        val selectedSliceInfo = findViewById<TextView>(R.id.selectedSliceInfo)
        val totalAmountText = findViewById<TextView>(R.id.totalAmountText)

        // Preluăm obiectivele
        val objectives = ObjectiveManager.getObjectives()
        Log.d("SavingsAdult", "Objectives: $objectives")

        if (objectives.isEmpty()) {
            totalAmountText.text = "Nu există economii"
            return
        }

        // Culorile pentru grafic
// Culorile pentru grafic
        val colors = listOf(
            Color.parseColor("#FF9966"), // atomic_tangerine
            Color.parseColor("#FE6F5E"), // bittersweet_orange
            Color.parseColor("#e24c00"), // bright_orange
            Color.parseColor("#E6812F"), // cadmium_orange
            Color.parseColor("#FAB972"), // calm_orange
            Color.parseColor("#FF7F50"), // coral
            Color.parseColor("#e9967a"), // dark_salmon
            Color.parseColor("#FFC3C3"), // blush_pink
            Color.parseColor("#FFD8D8")  // powder_pink
        )


        val dataForChart = objectives.mapIndexed { index, objective ->
            Triple(
                objective.sumaCurenta.toFloat(),
                colors[index % colors.size],
                objective.denumire
            )
        }
        Log.d("SavingsAdult", "Data for chart: $dataForChart")

        // Setăm datele în grafic
        pieChartView.setData(dataForChart)

        // Calculăm suma totală
        val totalAmount = objectives.sumOf { it.sumaCurenta }
        totalAmountText.text = "Total: $totalAmount lei"

        // Afișăm detalii despre felia selectată
        pieChartView.setOnSliceSelectedListener { _, slice ->
            val value = slice.first
            val color = slice.second
            val name = slice.third

            val totalSum = dataForChart.sumOf { it.first.toDouble() }
            selectedSliceInfo.text = String.format(
                "Categorie: %s\nSuma: %.0f lei\nProcent: %.1f%%",
                name,
                value,
                (value / totalSum) * 100
            )
            selectedSliceInfo.setTextColor(color)
        }
    }
}
