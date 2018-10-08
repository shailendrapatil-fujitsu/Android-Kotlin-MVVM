package com.android.arch.utils

import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Pattern


class Utils {

    companion object {

        fun getToday(): String {
            val date = Calendar.getInstance().time
            val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
            return dateFormat.format(date)
        }


    }
}