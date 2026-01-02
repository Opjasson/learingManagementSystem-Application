package com.example.educationapplication.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.educationapplication.Adapter.TaskAdapter
import com.example.educationapplication.Domain.TaskModal
import com.example.educationapplication.MainViewModal.ShowLessonViewModal
import com.google.firebase.firestore.FirebaseFirestore
import javax.security.auth.callback.Callback

class ShowLessonRepository {
//    database
    private val firebaseDatabase = FirebaseFirestore.getInstance()

//    get all data task
fun loadTask(
    lessonId: Long,
    callback: (List<TaskModal>) -> Unit
) {
    firebaseDatabase.collection("task")
        .whereEqualTo("lessonId", lessonId)
        .get()
        .addOnSuccessListener {
            callback(it.toObjects(TaskModal::class.java))
        }
}

}