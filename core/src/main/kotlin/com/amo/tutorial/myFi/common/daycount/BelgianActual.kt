package com.amo.tutorial.myFi.common.daycount

import java.time.LocalDate

class BelgianActual : MethodBelgian() {

    protected override fun getDenominator(to: LocalDate): Int = if ( to.isLeapYear() ) 366 else 365

}