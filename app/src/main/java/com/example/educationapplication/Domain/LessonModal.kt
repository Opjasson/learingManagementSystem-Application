package com.example.educationapplication.Domain

import java.io.Serializable

data class LessonModal(
    var lessonId: Number=0,
    var name: String="",
    var description: String=""
) : Serializable
