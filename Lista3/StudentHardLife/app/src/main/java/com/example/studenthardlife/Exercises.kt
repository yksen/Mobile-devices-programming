package com.example.studenthardlife

object Exercises {
    val exercises: MutableList<Exercise> = MutableList(5)
    {
        Exercise(
            "Exercise #$it",
            "This is exercise #$it"
        )
    }
}