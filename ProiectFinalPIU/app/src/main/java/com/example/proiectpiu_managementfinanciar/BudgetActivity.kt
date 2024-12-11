package com.example.proiectpiu_managementfinanciar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proiectpiu_managementfinanciar.R
import com.example.proiectpiu_managementfinanciar.adapters.BudgetListAdapter
import com.example.proiectpiu_managementfinanciar.models.BudgetItem

class BudgetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.budget_add_section) // Your main layout file

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
    }
}
