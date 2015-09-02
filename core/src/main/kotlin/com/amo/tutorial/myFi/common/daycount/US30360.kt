package com.amo.tutorial.myFi.common.daycount

import java.time.LocalDate

class US30360 : Method30360() {

    /**
     * JFin's like implementation
     */
    protected override fun dayOfMonth(from: LocalDate, to: LocalDate): Int {
        var dayOfMonth1 = from.getDayOfMonth();
        var dayOfMonth2 = to.getDayOfMonth();

        val isLastDayOfFebruary1 = DaycountCalculator.isLastDayOfFebruary(from);
        val isLastDayOfFebruary2 = DaycountCalculator.isLastDayOfFebruary(to);

        if (isLastDayOfFebruary1 && isLastDayOfFebruary2) {
            dayOfMonth2 = 30;
        }
        if (isLastDayOfFebruary1) {
            dayOfMonth1 = 30;
        }
        if (dayOfMonth2 == 31 && dayOfMonth1 >= 30) {
            dayOfMonth2 = 30;
        }
        if (dayOfMonth1 == 31) {
            dayOfMonth1 = 30;
        }
        return dayOfMonth2 - dayOfMonth1;
    }

    /*Implementation : source Source: 2006 ISDA Definitions, Sec. 4.16 (f)
    @Override
    protected double calculate(LocalDate from, LocalDate to) {

        int dayOfMonth1 = from.getDayOfMonth();
        int dayOfMonth2 = to.getDayOfMonth();
        int month1 = from.getMonthOfYear();
        int month2 = to.getMonthOfYear();
        int year1 = from.getYear();
        int year2 = to.getYear();

        if (dayOfMonth2 == 31 && dayOfMonth1 >= 30) {
            dayOfMonth2 = 30;
        }

        if (dayOfMonth1 == 31) {
            dayOfMonth1 = 30;
        }

        return getFactor(year1, year2, month1, month2, dayOfMonth1, dayOfMonth2);
    }*/

}