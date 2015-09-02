package com.amo.tutorial.myFi.common.daycount

import com.amo.tutorial.myFi.common.Fraction
import java.time.LocalDate
import java.time.Month
import java.time.temporal.ChronoUnit

class AFBActualActual : AbstractActual() {

    /**
     * @see http://en.wikipedia.org/wiki/Day_count_convention#Actual.2FActual_AFB
     */
    protected override fun calculate(from: LocalDate, to: LocalDate): Fraction {

        val numberOfWholeYear = ChronoUnit.YEARS.between(from, to)
        var DiY = 365

        var date3 = to.minusYears(numberOfWholeYear)

        if (date3.isLeapYear() || from.isLeapYear()) {
            var february29: LocalDate
            if (date3.isLeapYear()) {
                february29 = date3.with(Month.FEBRUARY).withDayOfMonth(29)
                if (numberOfWholeYear > 0 && date3.getMonth() == Month.FEBRUARY && date3.getDayOfMonth() == 28) {
                    //ISDA implementation
                    date3 = february29;
                }
            } else {
                february29 = from.with(Month.FEBRUARY).withDayOfMonth(29);
            }
            if (!from.isAfter(february29) && (date3.isAfter(february29) || (numberOfWholeYear > 0 && date3.isEqual(february29))))
                DiY++;
        }
        return Fraction((numberOfWholeYear * DiY + daysBetween(from, date3)).toInt(), DiY);
    }

}