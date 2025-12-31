package com.example.educationapplication.MainViewModal

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.educationapplication.Domain.TaskModal
import com.example.educationapplication.Repository.ShowLessonRepository

class ShowLessonViewModal: ViewModel() {
    private val repository = ShowLessonRepository()

    private val _task = MutableLiveData<MutableList<TaskModal>>()

    val task : LiveData<MutableList<TaskModal>> = _task

    fun loadData() {
        repository.loadTask() {
            _task.value = it
        }
    }
}