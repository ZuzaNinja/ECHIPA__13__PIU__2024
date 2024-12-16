package com.example.proiectpiu_managementfinanciar.models
import java.io.Serializable


data class UserRegistration(
    val name: String,
    val email: String,
    val phone: String,
    val password: String): Serializable{
}