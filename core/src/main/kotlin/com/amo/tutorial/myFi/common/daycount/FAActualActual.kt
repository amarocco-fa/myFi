package com.amo.tutorial.myFi.common.daycount;

import com.amo.tutorial.myFi.common.Fraction
import java.time.LocalDate
import java.time.Month

/**
 * FA implementation
 *
 */
class FAActualActual : AbstractActual() {

    protected override fun calculate(from: LocalDate, to: LocalDate): Fraction {

        var DiY = 365;

        if (from.isLeapYear() || to.isLeapYear()) {
            var february29: LocalDate;
            if (from.isLeapYear()) {
                february29 = from.with(Month.FEBRUARY).withDayOfMonth(29);
            } else {
                february29 = to.with(Month.FEBRUARY).withDayOfMonth(29);
            }
            if (from.isBefore(february29) && !to.isBefore(february29))
                DiY++;
        }
        return Fraction(daysBetween(from, to), DiY);
    }

}