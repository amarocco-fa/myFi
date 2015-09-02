package com.amo.tutorial.myFi.common.daycount

class Actual360 : MethodActual() {

    protected override fun getDenominator(): Int = 360

}