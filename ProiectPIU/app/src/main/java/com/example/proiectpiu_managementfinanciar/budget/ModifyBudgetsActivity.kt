package com.example.proiectpiu_managementfinanciar.budget

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.proiectpiu_managementfinanciar.R
import com.example.proiectpiu_managementfinanciar.home_dashboard.ParentDashboardActivity
import com.example.proiectpiu_managementfinanciar.login.MyAccountActivity
import com.example.proiectpiu_managementfinanciar.objective.ObjectiveStartPageActivityAdult
import com.example.proiectpiu_managementfinanciar.settings.SettingsStartActivity

class ModifyBudgetsActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var profile: View
    private lateinit var homeButton: View
    private lateinit var budgetButton: View
    private lateinit var goalsButton: View
    private lateinit var reportsButton: View
    private lateinit var settingsButton: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.budget_modify_section)

        val addBudgetsButton : ImageButton = findViewById(R.id.add_section_button)
        addBudgetsButton.setOnClickListener {
            val intent = Intent(this, NewBudgetActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        val editBudgetsButton : ImageButton = findViewById(R.id.modify_section_button)
        editBudgetsButton.setOnClickListener {
            val intent = Intent(this, ModifyBudgetsActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        val emergencyBudgetButton : ImageButton = findViewById(R.id.emergency_fund_button)
        emergencyBudgetButton.setOnClickListener {
            val intent = Intent(this, EmergencyBudgetActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        profile = findViewById(R.id.profile)
        homeButton = findViewById(R.id.homeButton)
        budgetButton = findViewById(R.id.budgetButton)
        goalsButton = findViewById(R.id.goalsButton)
        reportsButton = findViewById(R.id.reportsButton)
        settingsButton = findViewById(R.id.settingsButton)

        profile.setOnClickListener(this)
        homeButton.setOnClickListener(this)
        budgetButton.setOnClickListener(this)
        goalsButton.setOnClickListener(this)
        reportsButton.setOnClickListener(this)
        settingsButton.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
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
                val intent = Intent(this, ObjectiveStartPageActivityAdult::class.java)
                startActivity(intent)
            }
            R.id.reportsButton -> {
                //val intent = Intent(this, ReportsActivity::class.java)
                startActivity(intent)
            }
            R.id.settingsButton -> {
                startActivity(Intent(this, SettingsStartActivity::class.java))
            }

            R.id.profile -> {
                startActivity(Intent(this, MyAccountActivity::class.java))
            }
        }
    }
}