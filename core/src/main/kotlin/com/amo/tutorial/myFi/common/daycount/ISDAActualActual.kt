package com.amo.tutorial.myFi.common.daycount

import com.amo.tutorial.myFi.common.Fraction
import java.time.LocalDate
import java.time.Month
import java.time.temporal.ChronoUnit

class ISDAActualActual : AbstractActual() {

    protected override fun calculate(from: LocalDate, to: LocalDate): Fraction {

        val den1 = if (from.isLeapYear() ) 366 else 365

        if (from.getYear() == to.getYear()) {
            //less than one year
            return Fraction(daysBetween(from, to), den1);
        }
        //More than one year
        val fromT = from.with(Month.JANUARY).withDayOfMonth(1).plusYears(1);
        val toT = to.with(Month.JANUARY).withDayOfMonth(1);

        val sum = ChronoUnit.YEARS.between(fromT, toT);
        val den2 = if (to.isLeapYear() ) 366 else 365
        val den = den1 * den2;

        return Fraction((sum * den + daysBetween(from, fromT) * den2 + daysBetween(toT, to) * den1).toInt(), den);
    }

}