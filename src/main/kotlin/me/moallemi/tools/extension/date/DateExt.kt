/*
 * Copyright 2020 Reza Moallemi
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.moallemi.tools.extension.date

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import me.moallemi.tools.daterange.date.DateRange

fun Date.getMonthRange() = DateRange(startOfMonth, endOfMonth)

fun Date.getYearRange() = DateRange(startOfYear, endOfYear)

val Date.startOfMonth: Date
    get() = adjust(day = 1, hour = 0, minute = 0, second = 0, millisecond = 0)

val Date.endOfMonth: Date
    get() {
        calendar.time = this
        val lastDay = calendar.getActualMaximum(Calendar.DATE)
        return adjust(day = lastDay, hour = 23, minute = 59, second = 59, millisecond = 999)
    }

val Date.startOfYear: Date
    get() = adjust(month = 1, day = 1, hour = 0, minute = 0, second = 0, millisecond = 0)

val Date.endOfYear: Date
    get() = adjust(month = 12, day = 31, hour = 23, minute = 59, second = 59, millisecond = 999)

operator fun Date.plus(duration: Duration): Date {
    calendar.time = this
    calendar.add(duration.unit, duration.value)
    return calendar.time
}

operator fun Date.minus(duration: Duration): Date {
    calendar.time = this
    calendar.add(duration.unit, -duration.value)
    return calendar.time
}

fun Date.adjust(
    year: Int? = null,
    month: Int? = null,
    day: Int? = null,
    hour: Int? = null,
    minute: Int? = null,
    second: Int? = null,
    millisecond: Int? = null
): Date {
    calendar.time = this
    if (year != null) calendar.set(Calendar.YEAR, year)
    if (month != null) calendar.set(Calendar.MONTH, month - 1)
    if (day != null) calendar.set(Calendar.DATE, day)
    if (hour != null) calendar.set(Calendar.HOUR_OF_DAY, hour)
    if (minute != null) calendar.set(Calendar.MINUTE, minute)
    if (second != null) calendar.set(Calendar.SECOND, second)
    if (millisecond != null) calendar.set(Calendar.MILLISECOND, millisecond)
    return calendar.time
}

infix fun Date.isTheSameDayAs(other: Date): Boolean {
    calendar.time = this
    val otherCalendar = Calendar.getInstance().apply { time = other }
    return calendar.get(Calendar.YEAR) == otherCalendar.get(Calendar.YEAR) &&
        calendar.get(Calendar.MONTH) == otherCalendar.get(Calendar.MONTH) &&
        calendar.get(Calendar.DAY_OF_MONTH) == otherCalendar.get(Calendar.DAY_OF_MONTH)
}

fun Date.format(pattern: String, locale: Locale = Locale.getDefault()): String =
    SimpleDateFormat(pattern, locale).format(this)
