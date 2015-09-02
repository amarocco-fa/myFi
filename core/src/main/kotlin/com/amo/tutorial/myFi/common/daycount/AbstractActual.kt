package com.amo.tutorial.myFi.common.daycount

import com.amo.tutorial.myFi.common.Interval
import java.time.temporal.ChronoUnit

abstract class AbstractActual : DaycountCalculator() {

    protected override final fun daysBetween(closedInterval: Interval): Int = ChronoUnit.DAYS.between(closedInterval.getStart(), closedInterval.getEnd()).toInt()

}