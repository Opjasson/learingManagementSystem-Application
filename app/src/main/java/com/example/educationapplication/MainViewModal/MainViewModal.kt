package com.example.educationapplication.MainViewModal

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.educationapplication.Domain.LessonModal
import com.example.educationapplication.Repository.MainRepository

class MainViewModal : ViewModel() {
private val repository = MainRepository()
    private val _searchResult = MutableLiveData<MutableList<LessonModal>>()
    val searchResult: LiveData<MutableList<LessonModal>> = _searchResult

    fun searchValue(keyword : String) {
        if (keyword.isEmpty()) {
            loadAllLesson()
        } else {
            loadBySearchLesson(keyword)
        }
    }

    fun loadAllLesson() {
        repository.loadLesson() {
            _searchResult.value = it
        }
    }

    fun loadBySearchLesson(keyword: String) {
        repository.searchItems(keyword) {
            _searchResult.value = it
        }
    }
}