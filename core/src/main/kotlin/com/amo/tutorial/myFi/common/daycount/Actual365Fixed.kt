package com.amo.tutorial.myFi.common.daycount;

class Actual365Fixed : MethodActual() {

    protected override fun getDenominator(): Int = 365

}