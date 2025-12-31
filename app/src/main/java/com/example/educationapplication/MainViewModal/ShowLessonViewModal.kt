package com.example.educationapplication.MainViewModal

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.educationapplication.Domain.TaskModal
import com.example.educationapplication.Repository.ShowLessonRepository
import com.google.android.gms.common.api.internal.StatusCallback

class ShowLessonViewModal: ViewModel() {
    private val repository = ShowLessonRepository()

    fun loadData(callback: (MutableList<TaskModal>) -> Unit) {
        return repository.loadTask(callback)
    }
}