package com.aditprayogo.core.utils

import android.util.Log
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


fun String.toDate(
    dateFormat: String = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",
    timeZone: TimeZone = TimeZone.getTimeZone("UTC")
): Date? {
    val parser = SimpleDateFormat(dateFormat, Locale.getDefault())
    parser.timeZone = timeZone
    return try {
        parser.parse(this)
    } catch (e: ParseException) {
        Log.e(javaClass.name, e.message.toString())
        null
    }
}

fun Date.formatTo(
    dateFormat: String = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",
    timeZone: TimeZone = TimeZone.getDefault(),
    isConvertTime: Boolean = true,
    locale: Locale = Locale.getDefault()
): String {
    val formatter = SimpleDateFormat(dateFormat, locale)
    if (isConvertTime) formatter.timeZone = timeZone
    return formatter.format(this)
}