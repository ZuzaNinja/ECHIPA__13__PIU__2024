package com.example.proiectpiu_managementfinanciar.objective

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.proiectpiu_managementfinanciar.R
import com.example.proiectpiu_managementfinanciar.budget.MainBudgetActivity
import com.example.proiectpiu_managementfinanciar.home_dashboard.ParentDashboardActivity

class ObjectiveStartPageActivityAdult : AppCompatActivity(), View.OnClickListener {

    private lateinit var addObjectiveButton: ImageButton
    private lateinit var viewObjectivesButton: Button

    private lateinit var homeButton: View
    private lateinit var budgetButton: View
    private lateinit var goalsButton: View
    private lateinit var reportsButton: View
    private lateinit var settingsButton: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.objective_start_page_activity)

        initializeViews()

        setListeners()
    }

    private fun initializeViews() {
        addObjectiveButton = findViewById(R.id.addObjectiveButton)
        viewObjectivesButton = findViewById(R.id.viewObjectivesButton)

        homeButton = findViewById(R.id.homeButton)
        budgetButton = findViewById(R.id.budgetButton)
        goalsButton = findViewById(R.id.goalsButton)
        reportsButton = findViewById(R.id.reportsButton)
        settingsButton = findViewById(R.id.settingsButton)
    }

    private fun setListeners() {
        addObjectiveButton.setOnClickListener(this)
        viewObjectivesButton.setOnClickListener(this)

        homeButton.setOnClickListener(this)
        budgetButton.setOnClickListener(this)
        goalsButton.setOnClickListener(this)
        reportsButton.setOnClickListener(this)
        settingsButton.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.addObjectiveButton -> {
                startActivity(Intent(this, AddObjectiveActivityAdult::class.java))
            }
            R.id.viewObjectivesButton -> {
                startActivity(Intent(this, ViewObjectivesActivity::class.java))
            }
            R.id.homeButton -> {
                startActivity(Intent(this, ParentDashboardActivity::class.java))
            }
            R.id.budgetButton -> {
                startActivity(Intent(this, MainBudgetActivity::class.java))
            }
            R.id.goalsButton -> {
                startActivity(Intent(this, ObjectiveStartPageActivityAdult::class.java))
            }
            R.id.reportsButton -> {
                Toast.makeText(this, "Rapoarte (în lucru)", Toast.LENGTH_SHORT).show()
            }
            R.id.settingsButton -> {
                Toast.makeText(this, "Setări (în lucru)", Toast.LENGTH_SHORT).show()
            }
            else -> {
                Toast.makeText(this, "Acțiune necunoscută", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
