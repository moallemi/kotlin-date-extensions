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

fun Int.toYear() = Duration(unit = Calendar.YEAR, value = this)

fun Int.toMonth() = Duration(unit = Calendar.MONTH, value = this)

fun Int.toWeek() = Duration(unit = Calendar.WEEK_OF_MONTH, value = this)

fun Int.toDay() = Duration(unit = Calendar.DATE, value = this)

fun Int.toHour() = Duration(unit = Calendar.HOUR_OF_DAY, value = this)

fun Int.toMinute() = Duration(unit = Calendar.MINUTE, value = this)

fun Int.toSecond() = Duration(unit = Calendar.SECOND, value = this)

fun Int.toMillisecond() = Duration(unit = Calendar.MILLISECOND, value = this)
