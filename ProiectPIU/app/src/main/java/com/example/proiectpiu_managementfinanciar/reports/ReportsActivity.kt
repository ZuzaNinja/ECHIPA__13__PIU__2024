package com.example.proiectpiu_managementfinanciar.reports

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.proiectpiu_managementfinanciar.R
import com.example.proiectpiu_managementfinanciar.budget.MainBudgetActivity
import com.example.proiectpiu_managementfinanciar.home_dashboard.ParentDashboardActivity
import com.example.proiectpiu_managementfinanciar.login.MyAccountActivity
import com.example.proiectpiu_managementfinanciar.objective.ObjectiveStartPageActivityAdult
import com.example.proiectpiu_managementfinanciar.settings.SettingsStartActivity

class ReportsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reports)
    }

    fun onClick(v: View?) {
        when (v?.id) {
            R.id.profile -> startActivity(Intent(this, MyAccountActivity::class.java))
            R.id.cheltuieliButton -> startActivity(Intent(this, CheltuieliActivity::class.java))
        }
    }
}