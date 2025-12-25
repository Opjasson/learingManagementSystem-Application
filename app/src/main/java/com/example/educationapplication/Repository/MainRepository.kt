package com.example.educationapplication.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.educationapplication.Domain.LessonModal
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SnapshotListenOptions


class MainRepository {
    private val firebaseDatabase = FirebaseFirestore.getInstance()

    fun loadLesson(callback: (MutableList<LessonModal>) -> Unit) {
        firebaseDatabase.collection("lessons")
            .get()
            .addOnSuccessListener {
                callback(it.toObjects(LessonModal::class.java).toMutableList())
            }
    }

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