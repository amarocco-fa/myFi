package com.amo.tutorial.myFi.common.daycount

import java.time.LocalDate

class Belgian360 : MethodBelgian() {

    protected override fun getDenominator(to: LocalDate): Int = 360

}