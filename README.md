# Kotlin Date Extensions

[![GitHub Workflow Status](https://github.com/moallemi/kotlin-date-extensions/workflows/CI/badge.svg)](https://github.com/moallemi/kotlin-date-extensions/actions?query=workflow%3ACI)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/me.moallemi.tools/kotlin-date-extensions/badge.svg)](https://search.maven.org/artifact/me.moallemi.tools/kotlin-date-extensions)


Set of useful kotlin extension functions for Date

## Installation

Add the kotlin-date-extensions to your dependencies section:

```groovy
dependencies {
  implementation 'me.moallemi.tools:kotlin-date-extensions:0.0.1'
}
```


## How to use

### Top level functions

```kotlin
val now: Date = now()
val today: Date= today()
val yesterday: Date = yesterday()

// Date ranges

val currentMonthRange: DateRange = currentMonthRange()
val date: Date = now().adjust(year = 2020, month = 4, day = 28)
val result: Boolean = date in currentMonthRange // to check if this date is in current month or not

fun previousMonthRange(): DateRange
fun nextMonthRange(): DateRange
fun currentYearRange(): DateRange 
fun previousYearRange(): DateRange
fun nextYearRange(): DateRange
```
For more info about DateRange take a look at [Kotlin Date Range](https://github.com/moallemi/kotlin-date-range)

### Initialize by adjusting a date components

```kotlin
val date = Date().adjust(year = 2020, month = 4, day = 28, hour = 16, minute = 23, second = 45, millisecond = 999)
```

### Duration
```kotlin
val twoDaysAgo: Date = 2.toDay().ago
val tomorrow: Date = 1.toDay().sinceNow
val lastYear: Date = 1.toYear().ago
val nextMonth: Date = 1.toMonth().sinceNow
```

### Plus and minus operations
```kotlin
val twoMonthsAgo: Date = today() - 2.toMonth()
val tenYearsAfterHisBirthday = Date() + 10.toYear()
```

### Start and end date components
```kotlin
val startOfMonth = Date().startOfMonth
val endOfMonth = Date().endOfMonth

val startOfYear = Date().startOfYear
val endOfYear = Date().endOfYear
```

### Format and parse

```kotlin
Date().format("yyyy-MM-dd HH:mm:ss") // "2020-04-28 22:27:00"

val date = "2020-04-28".toDate("yyyy-MM-dd")
```

## License

```
Copyright 2020 Reza Moallemi.

Licensed to the Apache Software Foundation (ASF) under one or more contributor
license agreements. See the NOTICE file distributed with this work for
additional information regarding copyright ownership. The ASF licenses this
file to you under the Apache License, Version 2.0 (the "License"); you may not
use this file except in compliance with the License. You may obtain a copy of
the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
License for the specific language governing permissions and limitations under
the License.
```




