package com.example.physicsquiz

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class CheatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cheat)
    }

    fun browseForAnswer(view: View) {
        val url = "https://www.google.com/"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply {
            addCategory(Intent.CATEGORY_BROWSABLE)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
}