package com.example.educationapplication.Domain

import java.io.Serializable

data class LessonModal(
    var name: String="",
    var description: String=""
) : Serializable
