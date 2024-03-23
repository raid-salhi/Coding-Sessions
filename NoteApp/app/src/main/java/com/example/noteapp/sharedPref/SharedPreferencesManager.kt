package com.example.noteapp.sharedPref

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesManager(context: Context) {

        private val sharedPreferences: SharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        companion object {
            private const val STARTED = "started"
        }

        var started: String?
            get() = sharedPreferences.getString(STARTED, null)
            set(value) {
                sharedPreferences.edit().putString(STARTED, value).apply()
            }

}