package com.example.proiectpiu_managementfinanciar.budget

import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proiectpiu_managementfinanciar.R
import com.example.proiectpiu_managementfinanciar.adapters.BudgetListAdapter
import com.example.proiectpiu_managementfinanciar.home_dashboard.ParentDashboardActivity
import com.example.proiectpiu_managementfinanciar.models.BudgetItem

class NewBudgetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.budget_add_section) // Your main layout file

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

        // Initialize RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.budgets_recycler)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Example data for the budget list
        val budgetItems = listOf(
            BudgetItem("Groceries", 300),
            BudgetItem("Rent", 1200),
            BudgetItem("Utilities", 150)
        )

        // Set adapter
        val adapter = BudgetListAdapter(budgetItems)
        recyclerView.adapter = adapter

        setKeyboardVisibilityListener()
    }

    private fun setKeyboardVisibilityListener() {
        val rootView = findViewById<View>(android.R.id.content)
        val footerMenu = findViewById<View>(R.id.footer_menu)
        val navigationMenu = findViewById<View>(R.id.navigationMenu)

        rootView.viewTreeObserver.addOnGlobalLayoutListener {
            val rect = Rect()
            rootView.getWindowVisibleDisplayFrame(rect)

            val screenHeight = rootView.rootView.height
            val keypadHeight = screenHeight - rect.bottom

            if (keypadHeight > screenHeight * 0.15) {
                footerMenu.visibility = View.GONE
                navigationMenu.visibility = View.GONE
            } else {
                footerMenu.visibility = View.VISIBLE
                navigationMenu.visibility = View.VISIBLE
            }
        }
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
