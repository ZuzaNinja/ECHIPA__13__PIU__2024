package com.example.proiectpiu_managementfinanciar.home_dashboard

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.proiectpiu_managementfinanciar.R
import com.example.proiectpiu_managementfinanciar.objective.ObjectiveStartPageActivityAdolescent
import com.example.proiectpiu_managementfinanciar.settings.NotificationActivityAdolescent

class AdolescentDashboardActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var notificationIcon: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adolescent_dashboard)

        initializeViews()

        notificationIcon.setOnClickListener {
            startActivity(Intent(this, NotificationActivityAdolescent::class.java))
        }
    }

    private fun initializeViews() {
        findViewById<View>(R.id.homeButton).setOnClickListener(this)
        findViewById<View>(R.id.pusculitaButton).setOnClickListener(this)
        findViewById<View>(R.id.goalsButton).setOnClickListener(this)
        findViewById<View>(R.id.learnButton).setOnClickListener(this)

        notificationIcon = findViewById(R.id.notification_icon)

    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.homeButton -> {
                Toast.makeText(this, "Ești deja pe pagina principală!", Toast.LENGTH_SHORT).show()
            }
            R.id.pusculitaButton -> {
                Toast.makeText(this, "Funcționalitate în dezvoltare!", Toast.LENGTH_SHORT).show()
            }
            R.id.goalsButton -> {
                startActivity(Intent(this, ObjectiveStartPageActivityAdolescent::class.java))
            }
            R.id.learnButton -> {
                Toast.makeText(this, "Funcționalitate în dezvoltare!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
