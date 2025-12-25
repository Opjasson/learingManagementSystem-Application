package com.example.educationapplication.Repository

import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class AuthRepository {
    private val auth = FirebaseAuth.getInstance()

    fun loginAuth(
        email: String,
        password: String,
        onResult: (Boolean, String?) -> Unit
    ) {
        auth.signInWithEmailAndPassword(email, password).addOnSuccessListener {
            onResult(true, null)
        }.addOnFailureListener {
            e ->
            onResult(false, e.message)
        }
    }
}