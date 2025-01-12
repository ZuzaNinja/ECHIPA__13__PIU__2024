package com.example.proiectpiu_managementfinanciar.reports

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.proiectpiu_managementfinanciar.R
import com.example.proiectpiu_managementfinanciar.util.BudgetManager

class CheltuieliActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cheltuieli)

        val pieChartView = findViewById<CustomPieChart>(R.id.pieChartView)
        val selectedSliceInfo = findViewById<TextView>(R.id.selectedSliceInfo)
        val budgets = BudgetManager.getAllBudgets()
        val colors = listOf(
            Color.parseColor("#F59227"), Color.parseColor("#F8BC79"),
            Color.parseColor("#FCDB80"), Color.parseColor("#D76A00"),
            Color.parseColor("#FFC107"), Color.parseColor("#FAB972"),
            Color.parseColor("#FF7F50"), Color.parseColor("#FE6F5E")
        )

        val dataForChart = budgets.mapIndexed { index, budget ->
            Triple(budget.amount.toFloat(), colors[index % colors.size], budget.name)
        }

        pieChartView.setData(dataForChart)

// Totalul sumelor
        val totalAmount = BudgetManager.getTotalAmount()
        findViewById<TextView>(R.id.totalAmountText).text = "Total: $totalAmount lei"


        pieChartView.setOnSliceSelectedListener { index, slice ->
            val percentage = slice.first
            val color = slice.second
            val name = slice.third

            val selectedSliceInfo = findViewById<TextView>(R.id.selectedSliceInfo)
            selectedSliceInfo.text = String.format(
                "Cheltuială: %s\nSuma: %.0f lei\nProcent: %.1f%%",
                name, percentage, (percentage / 100) * 100 // Corectează calculul procentului dacă e necesar
            )
            selectedSliceInfo.setTextColor(color)
        }

    }
}
