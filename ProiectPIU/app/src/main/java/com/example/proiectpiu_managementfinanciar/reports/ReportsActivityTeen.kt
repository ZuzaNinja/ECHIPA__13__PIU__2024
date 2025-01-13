package com.example.proiectpiu_managementfinanciar.reports

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.proiectpiu_managementfinanciar.R

class ReportsActivityTeen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pusculita_adolescent)
    }

    fun onClick(v: View?) {
        when (v?.id) {
            R.id.bani_economisiti_section -> {
                val intent = Intent(this, SavingsTeen::class.java)
                startActivity(intent)
            }
            R.id.cheltuieli_section -> {
                val intent = Intent(this, CheltuieliAdolescent::class.java)
               startActivity(intent)
           }
        }
    }
}