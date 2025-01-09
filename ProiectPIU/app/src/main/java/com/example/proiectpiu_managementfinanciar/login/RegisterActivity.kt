package com.example.proiectpiu_managementfinanciar.login

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.proiectpiu_managementfinanciar.R
import com.example.proiectpiu_managementfinanciar.models.UserRegistration
import com.example.proiectpiu_managementfinanciar.util.RegistrationList


class RegisterActivity : AppCompatActivity() {

    private lateinit var nameInput: EditText
    private lateinit var emailInput: EditText
    private lateinit var phoneInput: EditText
    private lateinit var passwordInput: EditText
    private lateinit var confirmPasswordInput: EditText
    private lateinit var registerButton: Button
    private lateinit var googleIcon: ImageView

    private lateinit var textViewSuccess: TextView
    private lateinit var textViewFail: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        initializeViews()
        setListeners()
    }

    private fun initializeViews() {
        nameInput = findViewById(R.id.name_input)
        emailInput = findViewById(R.id.email_input)
        phoneInput = findViewById(R.id.phone_input)
        passwordInput = findViewById(R.id.password_input)
        confirmPasswordInput = findViewById(R.id.confirm_password_input)
        registerButton = findViewById(R.id.register_button)
        googleIcon = findViewById(R.id.google_icon)

        textViewSuccess = findViewById(R.id.textViewSignInMessage)
        textViewFail = findViewById(R.id.textViewLoginFailed)
    }

    private fun setListeners() {
        registerButton.setOnClickListener {
            if (validateInputs()) {

                val name = nameInput.text.toString()
                val email = emailInput.text.toString()
                val phone = phoneInput.text.toString()
                val password = passwordInput.text.toString()

                val newUser = UserRegistration(name, email, phone, password)
                RegistrationList.registrations.add(newUser)

                showMessage(textViewSuccess, getString(R.string.registration_successful))

                val intent = Intent(this, AuthenticationActivity::class.java)
                intent.putExtra("EXTRA_NAME", name)
                intent.putExtra("EXTRA_EMAIL", email)
                intent.putExtra("EXTRA_PHONE", phone)
                intent.putExtra("EXTRA_PASSWORD", password)
                startActivity(intent)
            } else {
                showMessage(textViewFail, getString(R.string.registration_failed))
            }
        }

        googleIcon.setOnClickListener {
            Toast.makeText(this, getString(R.string.redirect_to_google), Toast.LENGTH_SHORT).show()
        }
    }

    private fun validateInputs(): Boolean {
        val name = nameInput.text.toString()
        val email = emailInput.text.toString()
        val phone = phoneInput.text.toString()
        val password = passwordInput.text.toString()
        val confirmPassword = confirmPasswordInput.text.toString()

        if (name.isEmpty()) {
            Toast.makeText(this, getString(R.string.name_required), Toast.LENGTH_SHORT).show()
            return false
        }
        if (!name[0].isUpperCase()) {
            Toast.makeText(this, getString(R.string.name_capital_required), Toast.LENGTH_SHORT).show()
            return false
        }

        if (email.isEmpty()) {
            Toast.makeText(this, getString(R.string.email_required), Toast.LENGTH_SHORT).show()
            return false
        }
        if (!email.contains("@") || (!email.endsWith("gmail.com") && !email.endsWith("yahoo.com") && !email.endsWith("gmail.ro") && !email.endsWith("yahoo.ro"))) {
            Toast.makeText(this, getString(R.string.invalid_email), Toast.LENGTH_SHORT).show()
            return false
        }

        if (phone.isEmpty()) {
            Toast.makeText(this, getString(R.string.phone_required), Toast.LENGTH_SHORT).show()
            return false
        }
        if (phone.length != 10) {
            Toast.makeText(this, getString(R.string.phone_invalid), Toast.LENGTH_SHORT).show()
            return false
        }

        if (password.isEmpty()) {
            Toast.makeText(this, getString(R.string.password_required), Toast.LENGTH_SHORT).show()
            return false
        }
        if (password.length < 5) {
            Toast.makeText(this, getString(R.string.password_minimum_length), Toast.LENGTH_SHORT).show()
            return false
        }

        if (confirmPassword.isEmpty()) {
            Toast.makeText(this, getString(R.string.confirm_password_required), Toast.LENGTH_SHORT).show()
            return false
        }
        if (password != confirmPassword) {
            Toast.makeText(this, getString(R.string.passwords_do_not_match), Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }

    private fun showMessage(textView: TextView, message: String) {
        textView.text = message
        textView.visibility = View.VISIBLE
        Handler(Looper.getMainLooper()).postDelayed({
            textView.visibility = View.INVISIBLE
        }, 3000)
    }
}
