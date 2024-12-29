package com.example.proiectpiu_managementfinanciar.home_dashboard

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.proiectpiu_managementfinanciar.budget.MainBudgetActivity
import com.example.proiectpiu_managementfinanciar.R

class ParentDashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parent_dashboard)
    }

        fun onNavigationClick(view: View) {
            when (view.id) {
                R.id.adolescentButton -> {
                    //val intent = Intent(this, ContAdolescentActivity::class.java)
                    startActivity(intent)
                }
                R.id.homeButton -> {
                    val intent = Intent(this, ParentDashboardActivity::class.java)
                    startActivity(intent)
                }
                R.id.budgetButton -> {
                    val intent = Intent(this, MainBudgetActivity::class.java)
                    startActivity(intent)
                }
                R.id.goalsButton -> {
                    //val intent = Intent(this, GoalsActivity::class.java)
                    startActivity(intent)
                }
                R.id.reportsButton -> {
                    //val intent = Intent(this, ReportsActivity::class.java)
                    startActivity(intent)
                }
                R.id.settingsButton -> {
                    //val intent = Intent(this, SettingsActivity::class.java)
                    startActivity(intent)
                }
            }
    }
}
