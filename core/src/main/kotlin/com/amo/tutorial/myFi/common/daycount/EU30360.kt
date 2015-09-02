package com.amo.tutorial.myFi.common.daycount

import java.time.LocalDate

class EU30360 : Method30360() {

    protected override fun dayOfMonth(from: LocalDate, to: LocalDate): Int {
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

}