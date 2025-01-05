package com.example.proiectpiu_managementfinanciar.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.proiectpiu_managementfinanciar.R

class MyAccountActivity : AppCompatActivity() {

    private lateinit var logoutButton: Button
    private lateinit var profileImage: ImageView
    private lateinit var usernameTextView: TextView
    private lateinit var emailTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_account)

        profileImage = findViewById(R.id.profile_image)
        usernameTextView = findViewById(R.id.username_text)
        emailTextView = findViewById(R.id.email_text)
        logoutButton = findViewById(R.id.logout_button)

        val sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)
        val userEmail = sharedPreferences.getString("USER_EMAIL", "N/A")
        val userType = sharedPreferences.getString("USER_TYPE", "N/A")

        emailTextView.text = userEmail
        usernameTextView.text = userType

        if (userType == "Parent") {
            profileImage.setImageResource(R.drawable.adults)
        } else {
            profileImage.setImageResource(R.drawable.teenagers)
        }

        logoutButton.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.clear()
            editor.apply()

            val intent = Intent(this, StartActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}
