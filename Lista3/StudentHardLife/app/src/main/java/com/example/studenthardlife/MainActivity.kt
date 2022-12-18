package com.example.studenthardlife

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.studenthardlife.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val exercises = mutableListOf<Exercise>()
    var currentExerciseIndex: Int = 0

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = binding.root
        setContentView(view)
    }

}