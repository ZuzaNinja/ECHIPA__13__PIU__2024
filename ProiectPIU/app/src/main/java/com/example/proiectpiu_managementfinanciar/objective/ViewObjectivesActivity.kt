package com.example.proiectpiu_managementfinanciar.objective

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proiectpiu_managementfinanciar.R
import com.example.proiectpiu_managementfinanciar.adapters.ObjectiveAdapter
import com.example.proiectpiu_managementfinanciar.budget.MainBudgetActivity
import com.example.proiectpiu_managementfinanciar.home_dashboard.ParentDashboardActivity
import com.example.proiectpiu_managementfinanciar.util.ObjectiveManager

class ViewObjectivesActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ObjectiveAdapter

    private lateinit var homeButton: View
    private lateinit var budgetButton: View
    private lateinit var goalsButton: View
    private lateinit var reportsButton: View
    private lateinit var settingsButton: View


    private lateinit var manageObjectiveSection: LinearLayout
    private lateinit var manageObjectiveTitle: TextView
    private lateinit var manageObjectiveButton: ImageButton
    private lateinit var sumaInput: EditText
    private lateinit var adaugaSumaButton: Button
    private lateinit var anuleazaSumaButton: Button

    private lateinit var errorMessage1: LinearLayout
    private lateinit var errorMessageText1: TextView
    private lateinit var errorMessage2: LinearLayout
    private lateinit var errorMessageText2: TextView
    private lateinit var successMessage: LinearLayout
    private lateinit var successMessageText: TextView

    private val handler = android.os.Handler()

    private fun afisareTemporaraMesaje(view: View, durata: Long) {
        view.visibility = View.VISIBLE
        handler.postDelayed({
            view.visibility = View.GONE
        }, durata)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.objective_view_all_activity)

        recyclerView = findViewById(R.id.objectivesRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = ObjectiveAdapter(ObjectiveManager.getObjectives())
        recyclerView.adapter = adapter

        initializeViews()

        setListeners()
    }

    private fun initializeViews() {

        homeButton = findViewById(R.id.homeButton)
        budgetButton = findViewById(R.id.budgetButton)
        goalsButton = findViewById(R.id.goalsButton)
        reportsButton = findViewById(R.id.reportsButton)
        settingsButton = findViewById(R.id.settingsButton)

        manageObjectiveSection = findViewById(R.id.manageObjectiveSection)
        manageObjectiveTitle = findViewById(R.id.manageObjectiveTitle)
        manageObjectiveButton = findViewById(R.id.manageObjectiveButton)
        sumaInput = findViewById(R.id.sumaInput)
        adaugaSumaButton = findViewById(R.id.adaugaSumaButton)
        anuleazaSumaButton = findViewById(R.id.anuleazaSumaButton)

        errorMessage1 = findViewById(R.id.errorMessage1)
        errorMessageText1 = findViewById(R.id.errorMessageText1)
        errorMessage2 = findViewById(R.id.errorMessage2)
        errorMessageText2 = findViewById(R.id.errorMessageText2)
        successMessage = findViewById(R.id.successMessage)
        successMessageText = findViewById(R.id.successMessageText)

    }

    private fun setListeners() {
        homeButton.setOnClickListener(this)
        budgetButton.setOnClickListener(this)
        goalsButton.setOnClickListener(this)
        reportsButton.setOnClickListener(this)
        settingsButton.setOnClickListener(this)


        manageObjectiveButton.setOnClickListener {
            if (adapter.getSelectedPosition() != RecyclerView.NO_POSITION) {
                manageObjectiveSection.visibility = View.VISIBLE
                manageObjectiveTitle.visibility = View.GONE
                manageObjectiveButton.visibility = View.GONE
                adapter.lockSelection()
            } else {
                Toast.makeText(this, "Selectează un obiectiv înainte de a continua.", Toast.LENGTH_SHORT).show()
            }
        }

        adaugaSumaButton.setOnClickListener {
            val selectedPosition = adapter.getSelectedPosition()
            if (selectedPosition == RecyclerView.NO_POSITION) {
                Toast.makeText(this, "Selectează un obiectiv!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val sumaAdaugata = sumaInput.text.toString().toDoubleOrNull()

            // Resetare mesaje
            errorMessage1.visibility = View.GONE
            errorMessage2.visibility = View.GONE
            successMessage.visibility = View.GONE

            if (sumaAdaugata == null || sumaAdaugata <= 0) {
                afisareTemporaraMesaje(errorMessage1, 3000)
                errorMessageText1.text = "Specifică suma de adăugat!"
                return@setOnClickListener
            }

            val selectedObjective = ObjectiveManager.getObjectives()[selectedPosition]

            if (selectedObjective.sumaCurenta + sumaAdaugata > selectedObjective.sumaTotala) {
                afisareTemporaraMesaje(errorMessage2, 3000)
                errorMessageText2.text = "Suma adăugată depășește obiectivul ales!"

                sumaInput.text.clear()

            } else {
                selectedObjective.sumaCurenta += sumaAdaugata
                afisareTemporaraMesaje(successMessage, 3000)
                successMessageText.text = "Suma a fost adăugată cu succes!"

                sumaInput.text.clear()

                adapter.updateObjectives(ObjectiveManager.getObjectives())
                adapter.notifyDataSetChanged()


                if (selectedObjective.sumaCurenta == selectedObjective.sumaTotala) {
                    Toast.makeText(this, "Obiectiv completat! ✅", Toast.LENGTH_LONG).show()
                }

                manageObjectiveSection.visibility = View.GONE
                manageObjectiveTitle.visibility = View.VISIBLE
                manageObjectiveButton.visibility = View.VISIBLE
                adapter.unlockSelection()
            }
        }


        anuleazaSumaButton.setOnClickListener {
            manageObjectiveSection.visibility = View.GONE
            manageObjectiveTitle.visibility = View.VISIBLE
            manageObjectiveButton.visibility = View.VISIBLE
            adapter.unlockSelection()
        }


    }

    override fun onClick(view: View?) {
        when (view?.id) {
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

    override fun onResume() {
        super.onResume()
        adapter.updateObjectives(ObjectiveManager.getObjectives())
        adapter.notifyDataSetChanged()
    }

}
