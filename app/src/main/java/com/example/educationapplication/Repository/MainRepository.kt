package com.example.educationapplication.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.educationapplication.Domain.LessonModal
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SnapshotListenOptions


class MainRepository {
    private val firebaseDatabase = FirebaseFirestore.getInstance()

    fun loadLesson(): LiveData<MutableList<LessonModal>> {
        val listData = MutableLiveData<MutableList<LessonModal>>()

        firebaseDatabase.collection("lessons")
            .addSnapshotListener { snapshot, error ->
                if (error != null) return@addSnapshotListener

                val list = mutableListOf<LessonModal>()
                snapshot?.documents?.forEach { document ->
                    val item = document.toObject(LessonModal::class.java)
                    item?.let { list.add(it) }
                }

                listData.value = list
            }

        return listData
    }
}