package com.example.proiectpiu_managementfinanciar

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class AuthenticationActivity : AppCompatActivity() {

    private lateinit var emailInput: EditText
    private lateinit var passwordInput: EditText
    private lateinit var authenticateButton: Button
    private lateinit var googleIcon: ImageView
    private lateinit var registerLink: TextView
    private lateinit var forgotPassword: TextView

    private lateinit var textViewLoginFailed: TextView
    private lateinit var textViewSignInMessage: TextView

    private val handler = Handler(Looper.getMainLooper())

    private val validEmail = "admin@gmail.com"
    private val validPassword = "12345"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)

        initializeViews()
        setListeners()

        val email = intent.getStringExtra("EXTRA_EMAIL")
        val password = intent.getStringExtra("EXTRA_PASSWORD")

        emailInput.setText(email)
        passwordInput.setText(password)
    }

    private fun initializeViews() {
        emailInput = findViewById(R.id.email_input)
        passwordInput = findViewById(R.id.password_input)
        authenticateButton = findViewById(R.id.authenticate_button)
        googleIcon = findViewById(R.id.google_icon)
        registerLink = findViewById(R.id.register_link)
        forgotPassword = findViewById(R.id.forgot_password)

        textViewLoginFailed = findViewById(R.id.textViewLoginFailed)
        textViewSignInMessage = findViewById(R.id.textViewSignInMessage)
    }

    private fun setListeners() {
        authenticateButton.setOnClickListener {
            val validInputs = validateInputs()
            textViewLoginFailed.visibility = View.INVISIBLE
            textViewSignInMessage.visibility = View.INVISIBLE

            if (validInputs) {
                val enteredEmail = emailInput.text.toString()
                val enteredPassword = passwordInput.text.toString()

                if (enteredEmail == validEmail && enteredPassword == validPassword) {
                    afisareTemporaraMesaje(textViewSignInMessage, 3000)

                    handler.postDelayed({
//                        val intent = Intent(this, EmptyActivity::class.java)
                        val intent = Intent(this, BudgetActivity::class.java)
                        intent.putExtra("EXTRA_EMAIL", enteredEmail)
                        intent.putExtra("EXTRA_PASSWORD", enteredPassword)
                        startActivity(intent)
                    }, 1000)
                } else {
                    afisareTemporaraMesaje(textViewLoginFailed, 3000)
                }

            }
        }

        googleIcon.setOnClickListener {
            Toast.makeText(this, getString(R.string.redirect_to_google), Toast.LENGTH_SHORT).show()
        }

        registerLink.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        forgotPassword.setOnClickListener {
            Toast.makeText(this, getString(R.string.check), Toast.LENGTH_SHORT).show()
        }
    }

    private fun validateInputs(): Boolean {
        val email = emailInput.text.toString()
        val password = passwordInput.text.toString()

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, getString(R.string.verify_all), Toast.LENGTH_SHORT).show()
            return false
        }

        if (!email.contains("@") || (!email.endsWith("gmail.com") && !email.endsWith("yahoo.com") && !email.endsWith("gmail.ro") && !email.endsWith("yahoo.ro"))) {
            Toast.makeText(this, getString(R.string.invalid_email), Toast.LENGTH_SHORT).show()
            return false
        }

        if (password.length < 5) {
            Toast.makeText(this, getString(R.string.password_minimum_length), Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }

    private fun afisareTemporaraMesaje(textView: TextView, durata: Long) {
        textView.visibility = View.VISIBLE
        handler.postDelayed({
            textView.visibility = View.INVISIBLE
        }, durata)
    }
}
