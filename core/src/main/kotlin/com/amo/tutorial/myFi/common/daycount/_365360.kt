package com.amo.tutorial.myFi.common.daycount

import com.amo.tutorial.myFi.common.Fraction
import com.amo.tutorial.myFi.common.Interval
import java.time.LocalDate
import java.time.Month
import java.time.temporal.ChronoUnit

class _365360 : DaycountCalculator() {

    protected override fun daysBetween(closedInterval: Interval): Int {
        val from = closedInterval.getStart()
        val to = closedInterval.getEnd()

        val sum = ChronoUnit.YEARS.between(from, to)

        val date3 = from.plusYears(sum)
        var shift = 0
        if (date3.isLeapYear()) {
            val february29 = date3.with(Month.FEBRUARY).withDayOfMonth(29)
            if (date3.isBefore(february29) && to.isAfter(february29))
                shift--
        }
        return (sum * 365 + Math.max(ChronoUnit.DAYS.between(date3, to) + shift, 0)).toInt()
    }

    protected override fun calculate(from: LocalDate, to: LocalDate): Fraction = Fraction(daysBetween(from, to), 360)

}