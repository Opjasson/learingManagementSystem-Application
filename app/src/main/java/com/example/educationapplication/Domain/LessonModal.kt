package com.example.educationapplication.Domain

import java.io.Serializable

data class LessonModal(
    var name: String="",
    var lessonId: Long=0,
    var description: String=""
) : Serializable
