package com.example.studenthardlife

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.studenthardlife.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val exerciseLists: MutableList<ExerciseList> = ExerciseLists.lists

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = binding.root
        setContentView(view)
    }
}