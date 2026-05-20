package com.utama.loginsederhana

import android.content.Context
import android.content.SharedPreferences

class SessionManager(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("KendaraiinPrefs", Context.MODE_PRIVATE)

    companion object {
        private const val IS_LOGGED_IN = "isLoggedIn"
        private const val USERNAME = "username"
    }

    fun saveSession(username: String) {
        val editor = prefs.edit()
        editor.putBoolean(IS_LOGGED_IN, true)
        editor.putString(USERNAME, username)
        editor.apply()
    }

    fun isLoggedIn(): Boolean {
        return prefs.getBoolean(IS_LOGGED_IN, false)
    }

    fun getUsername(): String? {
        return prefs.getString(USERNAME, null)
    }

    fun clearSession() {
        val editor = prefs.edit()
        editor.clear()
        editor.apply()
    }
}