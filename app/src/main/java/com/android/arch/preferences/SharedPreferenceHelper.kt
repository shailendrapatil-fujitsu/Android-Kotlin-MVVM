package com.android.arch.preferences

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.android.arch.CONST_PREF_FILE_NAME
import javax.inject.Inject

class SharedPreferenceHelper @Inject constructor(application: Application) {

    private val sharedPreferences: SharedPreferences = application.getSharedPreferences(CONST_PREF_FILE_NAME, Context.MODE_PRIVATE)

    fun <T> putValue(key: String, value: T) {
        val editor = sharedPreferences.edit()
        if (value is String) {
            editor.putString(key, value as String).apply()
        } else if (value is Int) {
            editor.putInt(key, value as Int).apply()
        } else if (value is Float) {
            editor.putFloat(key, value as Float).apply()
        } else if (value is Boolean) {
            editor.putBoolean(key, value as Boolean).apply()
        } else if (value is Long) {
            editor.putLong(key, value as Long).apply()
        }
    }

    fun getString(key: String): String? {
        return sharedPreferences.getString(key, "")
    }

    fun getLong(key: String): Long? {
        return sharedPreferences.getLong(key, 0)
    }

    fun getFloat(key: String): Float? {
        return sharedPreferences.getFloat(key, 0f)
    }

    fun getBoolean(key: String): Boolean? {
        return sharedPreferences.getBoolean(key, false)
    }

    fun getInt(key: String): Int? {
        return sharedPreferences.getInt(key, 0)
    }

    fun getIntFromString(key: String): Int? {
        return Integer.parseInt(sharedPreferences.getString(key, "0")!!)
    }

    fun clear() {
        sharedPreferences.edit()
                .clear()
                .apply()
    }
}
