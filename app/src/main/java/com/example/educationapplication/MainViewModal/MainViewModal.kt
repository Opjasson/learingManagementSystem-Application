package com.example.educationapplication.MainViewModal

import androidx.lifecycle.LiveData
import com.example.educationapplication.Domain.LessonModal
import com.example.educationapplication.Repository.MainRepository

class MainViewModal {
private val repository = MainRepository()

    fun loadLesson(): LiveData<MutableList<LessonModal>> {
        return repository.loadLesson()
    }
}