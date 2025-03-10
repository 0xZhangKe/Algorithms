package com.zhangke.algorithms

import org.joda.time.format.ISODateTimeFormat
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.time.Duration
import kotlin.time.Duration.Companion.days
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.minutes
import kotlin.time.Duration.Companion.seconds
import kotlin.time.DurationUnit


fun main() {
    val formatter = FormatStatusDisplayTimeUseCase()
    val dateString = "2024-04-03T11:15:59.000Z"
    val date = parseISODate(dateString)
    println(date)
    println(formatter.format(date!!.time))
}

fun parseISODate(datetime: String): Date? {
    return try {
        ISODateTimeFormat.dateTime().parseDateTime(datetime).toDate()
    } catch (e: Throwable) {
        null
    }
}

class FormatStatusDisplayTimeUseCase {

    fun format(datetime: Long): String {
        val duration = (System.currentTimeMillis() - datetime).milliseconds
        return formatDuration(duration)
    }

    private fun formatDuration(duration: Duration): String {
        if (duration.isInfinite()) return ""
        var leftDuration = duration
        val day = (leftDuration).inWholeDays.days
        leftDuration -= day
        if (day > 0.days) {
            return "${day.toInt(DurationUnit.DAYS)} day"
        }
        val hours = leftDuration.inWholeHours.hours
        leftDuration -= hours
        if (hours > 0.hours) {
            return "${hours.toInt(DurationUnit.HOURS)} hour"
        }
        val minutes = leftDuration.inWholeMinutes.minutes
        leftDuration -= minutes
        if (minutes > 0.minutes) {
            return "${minutes.toInt(DurationUnit.MINUTES)} minutes"
        }
        val seconds = leftDuration.inWholeSeconds.seconds
        return "${seconds.toInt(DurationUnit.SECONDS)} second"
    }
}
