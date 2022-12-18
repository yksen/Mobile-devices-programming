package com.example.studenthardlife

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

private const val EXERCISE_LIST = "exercises"
private const val EXERCISE_FILE = "exercise_file"

fun saveExercisesList(context: Context, list: List<Exercise>) {
    val json = Gson().toJson(list)
    val sharedPreferences = context.getSharedPreferences(EXERCISE_FILE, Context.MODE_PRIVATE)
    sharedPreferences.edit().putString(EXERCISE_LIST, json).apply()
}

fun getExercisesList(context: Context): List<Exercise> {
    val sharedPreferences = context.getSharedPreferences(EXERCISE_FILE, Context.MODE_PRIVATE)
    val json = sharedPreferences.getString(EXERCISE_LIST, null)

    if (json.isNullOrEmpty()) {
        return emptyList()
    }

    val type = object : TypeToken<List<Exercise>>() {}.type
    return Gson().fromJson(json, type)
}