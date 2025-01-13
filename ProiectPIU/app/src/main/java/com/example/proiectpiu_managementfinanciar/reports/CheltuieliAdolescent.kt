package com.example.proiectpiu_managementfinanciar.reports

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.proiectpiu_managementfinanciar.R
import com.example.proiectpiu_managementfinanciar.models.BudgetItem

class CheltuieliAdolescent : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cheltuieli_adolescent)

        val pieChartViewAdolescent = findViewById<CustomPieChart>(R.id.pieChartViewAdolescent)
        val selectedSliceInfoAdolescent = findViewById<TextView>(R.id.selectedSliceInfoAdolescent)
        val totalAmountText = findViewById<TextView>(R.id.totalAmountText)

        // Date pentru cheltuielile adolescentului
        val adolescentBudgets = listOf(
            BudgetItem("Mâncare", 150),
            BudgetItem("Haine", 100),
            BudgetItem("Jocuri", 50),
            BudgetItem("Transport", 70)
        )

        // Culori pentru grafic
        val colorsAdolescent = listOf(
            Color.parseColor("#F59227"),
            Color.parseColor("#F8BC79"),
            Color.parseColor("#FCDB80"),
            Color.parseColor("#D76A00")
        )

        // Date pentru grafic
        val dataForChartAdolescent = adolescentBudgets.mapIndexed { index, budget ->
            Triple(budget.amount.toFloat(), colorsAdolescent[index % colorsAdolescent.size], budget.name)
        }

        // Configurare grafic
        pieChartViewAdolescent.setData(dataForChartAdolescent)

        // Calculăm suma totală a cheltuielilor
        val totalAmount = adolescentBudgets.sumOf { it.amount }
        totalAmountText.text = "Total: $totalAmount lei"

        // Afișare detalii felie selectată
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
