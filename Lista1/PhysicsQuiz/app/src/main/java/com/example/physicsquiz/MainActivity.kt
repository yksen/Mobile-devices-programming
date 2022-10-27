package com.example.physicsquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    private val trueButton: Button by lazy { findViewById(R.id.buttonTrue) }
    private val falseButton: Button by lazy { findViewById(R.id.buttonFalse) }
    private val questionText: TextView by lazy { findViewById(R.id.textViewQuestion) }

    private val questions: List<Question> = Questions.questions
    private var currentQuestionId: Int = 0
    private var score: Int = 0
    private var cheatCount: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setQuestion()

        if (savedInstanceState != null) {
            score = savedInstanceState.getString("score")?.toInt()!!
            cheatCount = savedInstanceState.getString("cheatCount")?.toInt()!!
        }

        falseButton.setOnClickListener {
            submitAnswer(false)
        }
        trueButton.setOnClickListener {
            submitAnswer(true)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("score", score.toString())
        outState.putString("cheatCount", cheatCount.toString())
    }

    private fun setQuestion() {
        val currentQuestion = questions[currentQuestionId]
        questionText.text = currentQuestion.content
    }

    private fun submitAnswer(givenAnswer: Boolean) {
        val currentQuestion = questions[currentQuestionId]
        score += if (currentQuestion.answer == givenAnswer) 10 else 0
        currentQuestionId++
        setQuestion()
    }

    fun startCheatActivity(view: View) {
        score -= 15
        val intent = Intent(this, CheatActivity::class.java)
        startActivity(intent)
    }
}