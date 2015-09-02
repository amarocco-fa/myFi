package com.amo.tutorial.myFi.common.daycount

import com.amo.tutorial.myFi.common.Fraction
import java.time.LocalDate

abstract class MethodActual : AbstractActual() {

    protected override final fun calculate(from: LocalDate, to: LocalDate): Fraction = Fraction(daysBetween(from, to), getDenominator())

    protected abstract fun getDenominator(): Int

}