package com.example.educationapplication.Repository

import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class AuthRepository {
    private val auth = FirebaseAuth.getInstance()
    private val database = FirebaseFirestore.getInstance()

//    Login handle firestore
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

//    Register handle firestore
fun registerAuth(
    name: String,
    email: String,
    password: String,
    onResult: (Boolean, String?) -> Unit
){
    auth.createUserWithEmailAndPassword(email, password).addOnSuccessListener {
        result ->
        val uid = result.user!!.uid

        val user = hashMapOf(
            "name" to name,
            "email" to email,
            "password" to password
        )

        database.collection("users").document(uid).set(user)
        onResult(true, null)
    }.addOnFailureListener {
        e ->
        onResult(false, e.message)
    }
}
}