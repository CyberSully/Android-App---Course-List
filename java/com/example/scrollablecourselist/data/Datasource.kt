package com.example.scrollablecourselist.data

import com.example.scrollablecourselist.R
import com.example.scrollablecourselist.model.Course

class CourseDataSource {
    fun loadCourses(): List<Course> {
        return listOf(
            Course(R.string.course_extra, "Assignment", 3, 1),
            Course(R.string.course_161, "CS", 161, 100),
            Course(R.string.course_162, "CS", 162, 100),
            Course(R.string.course_225, "CS", 225, 200),
            Course(R.string.course_261, "CS", 261, 200),
            Course(R.string.course_271, "CS", 271, 200),
            Course(R.string.course_290, "CS", 290, 200),
            Course(R.string.course_325, "CS", 325, 300),
            Course(R.string.course_340, "CS", 340, 300),
            Course(R.string.course_344, "CS", 344, 300),
            Course(R.string.course_361, "CS", 361, 300),
            Course(R.string.course_362, "CS", 362, 300),
            Course(R.string.course_467, "CS", 467, 400),
        )
    }
}
