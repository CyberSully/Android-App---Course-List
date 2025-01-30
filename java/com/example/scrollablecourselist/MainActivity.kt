package com.example.scrollablecourselist


import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.scrollablecourselist.data.CourseDataSource
import com.example.scrollablecourselist.model.Course
import com.example.scrollablecourselist.ui.theme.ScrollableCourseListTheme

// Brett Sullivan - Sullbret@oregonstate.edu
// CS 492 - Mobile App Development - Winter 2025 - 1-28-2025

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScrollableCourseListTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFBB86FC)
                )

                {
                    CourseListScreen()
                }
            }
        }
    }
}

@Composable
fun CourseListScreen() {
    val courseList = CourseDataSource().loadCourses()
    Box(
        modifier = Modifier.fillMaxSize(), // Fill the entire screen
        contentAlignment = Alignment.Center // Align the content in the center
    ) {
        CourseList(courseList = courseList, modifier = Modifier.padding(16.dp))
    }
}



@Composable
fun CourseCard(course: Course, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF90EE90)) // Example color
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "${course.department} ${course.number}",
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold)
            )
            Text(
                text = stringResource(id = course.titleResId),
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = "Capacity: ${course.capacity}",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
fun CourseList(courseList: List<Course>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxWidth() // Take the full width
            .wrapContentHeight(align = Alignment.CenterVertically) // Center vertically
    ) {
        items(courseList) { course ->
            CourseCard(
                course = course,
                modifier = Modifier
                    .padding(8.dp) // Add padding around each card
                    .fillMaxWidth(0.8f) // Optionally, set width to control card size (e.g., 80% of screen width)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CourseListPreview() {
    ScrollableCourseListTheme {
        CourseListScreen()
    }
}