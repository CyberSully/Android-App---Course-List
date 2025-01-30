package com.example.scrollablecourselist.model

data class Course(
    val titleResId: Int, // Resource ID for the course title
    val department: String,
    val number: Int,
    val capacity: Int
) {
}
