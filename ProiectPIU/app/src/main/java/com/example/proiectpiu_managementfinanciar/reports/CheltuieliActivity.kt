package com.example.proiectpiu_managementfinanciar.reports

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.proiectpiu_managementfinanciar.R

class CheltuieliActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cheltuieli)

        val pieChartView = findViewById<CustomPieChart>(R.id.pieChartView)
        val selectedSliceInfo = findViewById<TextView>(R.id.selectedSliceInfo)

        pieChartView.setOnSliceSelectedListener { _, slice ->
            val percentage = slice.first
            val color = slice.second
            val name = slice.third

            selectedSliceInfo.text = String.format(
                "%f%% %s                          %.0f lei",
                percentage,
                name,
                percentage * 10 // Exemplu de calcul pentru sumă
            )
            selectedSliceInfo.setTextColor(color)
        }
    }
}
