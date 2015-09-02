package com.amo.tutorial.myFi.common.daycount

import com.amo.tutorial.myFi.common.Fraction
import com.amo.tutorial.myFi.common.Interval
import java.time.LocalDate
import java.time.temporal.ChronoUnit

class Adjusted30360 : DaycountCalculator() {

    /*
            Start date: MONTH1/DAY1/YEAR1
            End date  : MONTH2/DAY2/YEAR2
            Day count = NBMOIS*30 + 31-D1+D2-1
            Where NBMOIS = 1/MONTH2/YEAR2 - 1/MONTH1+1/YEAR1
    */
    protected override final fun daysBetween(closedInterval: Interval): Int {
        val from = closedInterval.getStart();
        val to = closedInterval.getEnd();

        val nbMonths = ChronoUnit.MONTHS.between(from.withDayOfMonth(1).plusMonths(1), to.withDayOfMonth(1)).toInt();

        val dayOfMonth1 = from.getDayOfMonth();
        val dayOfMonth2 = to.getDayOfMonth();

        var numerator = 31 - dayOfMonth1 + dayOfMonth2 - 1;
        numerator += 30 * (nbMonths);
        return numerator;
    }

    protected override final fun calculate(from: LocalDate, to: LocalDate): Fraction = Fraction(daysBetween(from, to), 360)

}