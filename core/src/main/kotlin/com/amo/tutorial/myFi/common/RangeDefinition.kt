package com.amo.tutorial.myFi.common

import java.time.LocalDate

enum class RangeDefinition {

    OPEN {
        override fun range(start: LocalDate, end: LocalDate): Interval = Interval(start.plusDays(1), end.minusDays(1))
    },
    CLOSED {
        override fun range(start: LocalDate, end: LocalDate): Interval = Interval(start, end)
    },
    CLOSED_OPEN {
        override fun range(start: LocalDate, end: LocalDate): Interval = Interval(start, end.minusDays(1))
    },
    OPEN_CLOSED {
        override fun range(start: LocalDate, end: LocalDate): Interval = Interval(start.plusDays(1), end)
    };

    fun contains(start: LocalDate, end: LocalDate, value: LocalDate): Boolean = range(start, end).contains(value)

    abstract fun range(start: LocalDate, end: LocalDate): Interval

}