package com.amo.tutorial.myFi.common.daycount

import com.amo.tutorial.myFi.common.Fraction
import com.amo.tutorial.myFi.common.Interval
import java.time.LocalDate
import java.time.temporal.ChronoUnit

abstract class MethodBelgian : DaycountCalculator() {

    /**
     * si une échéance commence le 31/12 =>  nombre de jour dans la base de taux belge = (date début échéance - date fin échéance) -1<br/>
     * si une échéance se termine le 31/12 => nombre de jour dans la base de taux belge = (date début échéance - date fin échéance) +1
     *
     */
    protected override final fun daysBetween(closedInterval: Interval): Int {
        val from = closedInterval.getStart();
        val to = closedInterval.getEnd();

        var dayGap = ChronoUnit.DAYS.between(from, to);

        if (DaycountCalculator.isLastDayOfDecember(from)) {
            dayGap--;
        }
        if (DaycountCalculator.isLastDayOfDecember(to)) {
            dayGap++;
        }
        return dayGap.toInt();
    }

    protected override final fun calculate(from: LocalDate, to: LocalDate): Fraction = Fraction(daysBetween(from, to), getDenominator(to))

    protected abstract fun getDenominator(to: LocalDate): Int ;

}