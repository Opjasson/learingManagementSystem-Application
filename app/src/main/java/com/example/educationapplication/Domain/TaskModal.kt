package com.example.educationapplication.Domain

import java.io.Serializable

data class TaskModal(
    var lessonId: Long = 0,
    var soal: String = "",
    var pilihan1: String = "",
    var pilihan2: String = "",
    var pilihan3: String = "",
    var pilihan4: String = "",
    var answer: String = "",
) : Serializable
