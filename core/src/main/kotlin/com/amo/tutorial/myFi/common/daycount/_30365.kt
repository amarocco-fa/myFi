package com.amo.tutorial.myFi.common.daycount

import com.amo.tutorial.myFi.common.Fraction
import com.amo.tutorial.myFi.common.Interval
import java.time.LocalDate

class _30365 : DaycountCalculator() {

    protected fun dayOfMonth(from: LocalDate, to: LocalDate): Int {
        var dayOfMonth1 = from.getDayOfMonth();
        var dayOfMonth2 = to.getDayOfMonth();

        if (dayOfMonth1 == 31) {
            dayOfMonth1 = 30;
        }
        if (dayOfMonth2 == 31) {
            dayOfMonth2 = 30;
        }
        return dayOfMonth2 - dayOfMonth1;
    }

    /**
     * Figure representing the amount of the CouponRate to apply in calculating Interest.
     * It is often expressed as "days in the accrual period / days in the year".
     * If Date2 is a coupon payment date, Factor is zero.
     *
     * @param closedInterval [date1, date2]
     * @return (dayOfMonth2 - dayOfMonth1) + [ 30 * (month2 - month1) ] + [ 360 * (year2 - year1) ]
     */
    protected override final fun daysBetween(closedInterval: Interval): Int {
        val date1 = closedInterval.getStart();
        val date2 = closedInterval.getEnd();

        var numerator = dayOfMonth(date1, date2);
        numerator += 360 * (date2.getYear() - date1.getYear());
        numerator += 30 * (date2.getMonthValue() - date1.getMonthValue());
        return numerator;
    }

    protected override final fun calculate(from: LocalDate, to: LocalDate): Fraction {
        return Fraction(daysBetween(from, to), 365);
    }

}