package com.freelanxer.formularacing.extension

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

fun Date.formatToString(pattern: DateFormatPattern): String {
    val sdf = SimpleDateFormat(pattern.value, Locale.getDefault())
    return sdf.format(this)
}

fun Date.plusMonth(month: Int): Date {
    val cal = Calendar.getInstance()
    cal.time = this
    cal.add(Calendar.MONTH, month)
    return cal.time
}

fun Date.minusMonth(month: Int): Date {
    val cal = Calendar.getInstance()
    cal.time = this
    cal.add(Calendar.MONTH, month.unaryMinus())
    return cal.time
}

fun String.dateFormat(
    inputFormat: DateFormatPattern,
    outputFormat: DateFormatPattern
): String {
    val sdf = SimpleDateFormat(inputFormat.value, Locale.getDefault())
    val outputSdf = SimpleDateFormat(outputFormat.value, Locale.getDefault())
    val date = sdf.parse(this)
    return date?.let { outputSdf.format(it) } ?: this
}

sealed class DateFormatPattern(val value: String) {
    data object YYYY : DateFormatPattern(value = "yyyy")
    data object YYYYMMDD : DateFormatPattern(value = "yyyyMMdd")
    data object YYYYMMDD_SlASH : DateFormatPattern(value = "yyyy/MM/dd")
    data object YYYYMMDD_DASH : DateFormatPattern(value = "yyyy-MM-dd")
    data object UTC_ISO_8601 : DateFormatPattern(value = "yyyy-MM-dd'T'HH:mm:ss")
    data object MMDDHHMM : DateFormatPattern(value = "MM/dd HH:mm")
}