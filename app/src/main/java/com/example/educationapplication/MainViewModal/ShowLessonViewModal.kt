package com.example.educationapplication.MainViewModal

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.educationapplication.Domain.LessonModal
import com.example.educationapplication.Domain.TaskModal
import com.example.educationapplication.Repository.ShowLessonRepository
import com.google.android.gms.common.api.internal.StatusCallback

class ShowLessonViewModal: ViewModel() {

    private val _searchResult = MutableLiveData<List<TaskModal>>()
    val searchResult: LiveData<List<TaskModal>> = _searchResult
    private val repository = ShowLessonRepository()

    fun loadData(id : Long) {
        repository.loadTask(id) {
            _searchResult.value = it
        }
    }

}