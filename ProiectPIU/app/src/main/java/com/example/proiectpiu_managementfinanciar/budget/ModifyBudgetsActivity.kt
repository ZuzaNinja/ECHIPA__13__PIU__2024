package com.example.proiectpiu_managementfinanciar.budget

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.proiectpiu_managementfinanciar.R

class ModifyBudgetsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.budget_modify_section)

        val addBudgetsButton : ImageButton = findViewById(R.id.add_section_button)

        addBudgetsButton.setOnClickListener {
            val intent = Intent(this, BudgetActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}