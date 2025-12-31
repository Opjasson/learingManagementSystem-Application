package com.example.educationapplication.Repository

import com.example.educationapplication.Domain.TaskModal
import com.google.firebase.firestore.FirebaseFirestore
import javax.security.auth.callback.Callback

class ShowLessonRepository {
//    database
    private val firebaseDatabase = FirebaseFirestore.getInstance()

//    get all data task
fun loadTask(callback: (MutableList<TaskModal>) -> Unit) {
    firebaseDatabase.collection("task")
        .get()
        .addOnSuccessListener {
            callback(it.toObjects(TaskModal::class.java).toMutableList())
        }
}

}