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

import java.util.Calendar
import java.util.Date
import junit.framework.TestCase.assertEquals
import org.junit.Test

class TopLevelFunctionsKtTest {

    private val calendar: Calendar by lazy { Calendar.getInstance() }

    @Test fun testCurrentMonthRange() {
        calendar.time = Date()
        val endDayOfMonth = calendar.getActualMaximum(Calendar.DATE)
        val expected = arrayListOf<String>()
        for (i in 1..endDayOfMonth) {
            calendar.set(Calendar.DAY_OF_MONTH, i)
            calendar.set(Calendar.HOUR_OF_DAY, 0)
            calendar.set(Calendar.MINUTE, 0)
            calendar.set(Calendar.SECOND, 0)
            calendar.set(Calendar.MILLISECOND, 0)
            expected.add(calendar.time.toString())
        }
        val actual = currentMonthRange().asIterable().map { it.toString() }
        assertEquals(expected, actual)
    }

    @Test fun testPreviousMonthRange() {
        calendar.time = Date()
        calendar.add(Calendar.MONTH, -1)
        val endDayOfMonth = calendar.getActualMaximum(Calendar.DATE)
        val expected = arrayListOf<String>()
        for (i in 1..endDayOfMonth) {
            calendar.set(Calendar.DAY_OF_MONTH, i)
            calendar.set(Calendar.HOUR_OF_DAY, 0)
            calendar.set(Calendar.MINUTE, 0)
            calendar.set(Calendar.SECOND, 0)
            calendar.set(Calendar.MILLISECOND, 0)
            expected.add(calendar.time.toString())
        }
        val actual = previousMonthRange().asIterable().map { it.toString() }
        assertEquals(expected, actual)
    }

    @Test fun testNextMonthRange() {
        calendar.time = Date()
        calendar.add(Calendar.MONTH, 1)
        val endDayOfMonth = calendar.getActualMaximum(Calendar.DATE)
        val expected = arrayListOf<String>()
        for (i in 1..endDayOfMonth) {
            calendar.set(Calendar.DAY_OF_MONTH, i)
            calendar.set(Calendar.HOUR_OF_DAY, 0)
            calendar.set(Calendar.MINUTE, 0)
            calendar.set(Calendar.SECOND, 0)
            calendar.set(Calendar.MILLISECOND, 0)
            expected.add(calendar.time.toString())
        }
        val actual = nextMonthRange().asIterable().map { it.toString() }
        assertEquals(expected, actual)
    }

    @Test fun testCurrentYearRange() {
        calendar.time = Date()
        val expected = arrayListOf<String>()
        for (month in 1..12) {
            calendar.set(Calendar.DAY_OF_MONTH, 1)
            calendar.set(Calendar.MONTH, month - 1)
            val endDayOfMonth = calendar.getActualMaximum(Calendar.DATE)
            for (day in 1..endDayOfMonth) {
                calendar.set(Calendar.DAY_OF_MONTH, day)
                calendar.set(Calendar.HOUR_OF_DAY, 0)
                calendar.set(Calendar.MINUTE, 0)
                calendar.set(Calendar.SECOND, 0)
                calendar.set(Calendar.MILLISECOND, 0)
                expected.add(calendar.time.toString())
            }
        }
        val actual = currentYearRange().asIterable().map { it.toString() }
        assertEquals(expected, actual)
    }

    @Test fun testPreviousYearRange() {
        calendar.time = Date()
        calendar.add(Calendar.YEAR, -1)
        val expected = arrayListOf<String>()
        for (month in 1..12) {
            calendar.set(Calendar.DAY_OF_MONTH, 1)
            calendar.set(Calendar.MONTH, month - 1)
            val endDayOfMonth = calendar.getActualMaximum(Calendar.DATE)
            for (day in 1..endDayOfMonth) {
                calendar.set(Calendar.DAY_OF_MONTH, day)
                calendar.set(Calendar.HOUR_OF_DAY, 0)
                calendar.set(Calendar.MINUTE, 0)
                calendar.set(Calendar.SECOND, 0)
                calendar.set(Calendar.MILLISECOND, 0)
                expected.add(calendar.time.toString())
            }
        }
        val actual = previousYearRange().asIterable().map { it.toString() }
        assertEquals(expected, actual)
    }

    @Test fun testNextYearRange() {
        calendar.time = Date()
        calendar.add(Calendar.YEAR, 1)
        val expected = arrayListOf<String>()
        for (month in 1..12) {
            calendar.set(Calendar.DAY_OF_MONTH, 1)
            calendar.set(Calendar.MONTH, month - 1)
            val endDayOfMonth = calendar.getActualMaximum(Calendar.DATE)
            for (day in 1..endDayOfMonth) {
                calendar.set(Calendar.DAY_OF_MONTH, day)
                calendar.set(Calendar.HOUR_OF_DAY, 0)
                calendar.set(Calendar.MINUTE, 0)
                calendar.set(Calendar.SECOND, 0)
                calendar.set(Calendar.MILLISECOND, 0)
                expected.add(calendar.time.toString())
            }
        }
        val actual = nextYearRange().asIterable().map { it.toString() }
        assertEquals(expected, actual)
    }
}
