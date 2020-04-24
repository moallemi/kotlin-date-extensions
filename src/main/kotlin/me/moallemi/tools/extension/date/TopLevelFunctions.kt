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
import me.moallemi.tools.daterange.date.DateRange

internal val calendar: Calendar by lazy {
    Calendar.getInstance()
}

fun now() = Date()

fun today() = Date()

fun yesterday() = today() - 1.toDay()

fun currentMonthRange(): DateRange = today().getMonthRange()

fun previousMonthRange(): DateRange = (today() - 1.toMonth()).getMonthRange()

fun nextMonthRange() = (today() + 1.toMonth()).getMonthRange()

fun currentYearRange(): DateRange = today().getYearRange()

fun previousYearRange(): DateRange = (today() - 1.toYear()).getYearRange()

fun nextYearRange(): DateRange = (today() + 1.toYear()).getYearRange()
