package com.example.physicsquiz

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class CheatActivity : AppCompatActivity() {
    private var score: Int = 0
    private var cheatCount: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cheat)

        if (savedInstanceState != null) {
            score = savedInstanceState.getString("score")?.toInt()!!
            cheatCount = savedInstanceState.getString("cheatCount")?.toInt()!!
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("score", score.toString())
        outState.putString("cheatCount", cheatCount.toString())
    }

    fun browseForAnswer(view: View) {
        val url = "https://www.google.com/"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply {
            addCategory(Intent.CATEGORY_BROWSABLE)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
            score -= 15
            cheatCount++
        }
    }
}