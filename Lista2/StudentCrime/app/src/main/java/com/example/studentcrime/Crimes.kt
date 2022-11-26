package com.example.studentcrime

import kotlin.random.Random

object Crimes {
    val crimes: List<Crime> = List(20)
    {
        Crime(
            "Crime #$it",
            "Description of crime #$it",
            Random.nextInt(),
            Random.nextBoolean()
        )
    }
}