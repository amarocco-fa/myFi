package com.amo.tutorial.myFi.common.daycount

import com.amo.tutorial.myFi.common.Fraction
import com.amo.tutorial.myFi.common.Interval
import com.amo.tutorial.myFi.common.RangeDefinition
import java.time.LocalDate
import java.time.Month
import kotlin.platform.platformStatic

abstract class DaycountCalculator {

    final fun calculateDaycountFractionAsDouble(from: LocalDate, to: LocalDate): Double = calculateDaycountFraction(from, to).getValue()

    final fun calculateDaycountFraction(from: LocalDate, to: LocalDate): Fraction {
        if (from.isEqual(to)) {
            return Fraction.ZERO
        }
        return calculate(from, to)
    }

    final fun daysBetween(from: LocalDate, to: LocalDate): Int = daysBetween(from, to, RangeDefinition.CLOSED)

    final fun daysBetween(from: LocalDate, to: LocalDate, definition: RangeDefinition): Int = daysBetween(definition.range(from, to))

    protected abstract fun daysBetween(closedInterval: Interval): Int

    protected abstract fun calculate(from: LocalDate, to: LocalDate): Fraction

    companion object {
        platformStatic final fun isLastDayOfFebruary(date: LocalDate): Boolean = date.getDayOfMonth() == date.lengthOfMonth() && date.getMonth() == Month.FEBRUARY

        platformStatic final fun isLastDayOfDecember(date: LocalDate): Boolean = 31 == date.getDayOfMonth() && date.getMonth() == Month.DECEMBER
    }

}