package com.example.educationapplication.Repository

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.educationapplication.Activity.LoginActivity
import com.example.educationapplication.Domain.LessonModal
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SnapshotListenOptions


class MainRepository {

//    Initialisasi firestore DB
    private val firebaseDatabase = FirebaseFirestore.getInstance()


//    Get all lesson MainActivity
    fun loadLesson(callback: (MutableList<LessonModal>) -> Unit) {
        firebaseDatabase.collection("lessons")
            .get()
            .addOnSuccessListener {
                callback(it.toObjects(LessonModal::class.java).toMutableList())
            }
    }

//    Handle search lesson MainActivity
    fun searchItems(
        keyword: String,
        callback: (MutableList<LessonModal>) -> Unit
    ) {
        FirebaseFirestore.getInstance()
            .collection("lessons")
            .orderBy("name")
            .startAt(keyword)
            .endAt(keyword + "\uf8ff")
            .get()
            .addOnSuccessListener {
                callback(it.toObjects(LessonModal::class.java).toMutableList())
            }
    }

}