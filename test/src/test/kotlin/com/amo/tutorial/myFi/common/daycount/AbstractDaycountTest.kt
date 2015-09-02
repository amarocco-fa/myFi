package com.amo.tutorial.myFi.common.daycount

import com.amo.tutorial.interval
import com.amo.tutorial.myFi.common.DaycountConvention
import com.amo.tutorial.myFi.common.Fraction
import com.amo.tutorial.myFi.common.Interval
import com.amo.tutorial.oneYearInterval
import junitparams.Parameters
import org.assertj.core.api.Kassertions
import org.assertj.core.data.Offset
import org.junit.Test

abstract class AbstractDaycountTest(private final val daycountConvention: DaycountConvention) {

    abstract fun definitionSample(): Array<Any>

    class Parameter(i: Interval, d: Fraction) {

        val interval: Interval
        val expected: Fraction

        init {
            this.interval = i
            this.expected = d
        }
    }

    @Test
    @Parameters(method = "parameter")
    fun testDefinitions(p: Parameter) {
        val current = daycountConvention.getCalculator().calculateDaycountFractionAsDouble(p.interval.getStart(), p.interval.getEnd())
        Kassertions.assertThat(current)
                .`as`("result does not fit definition for " + daycountConvention + " and " + p.interval)
                .isEqualTo(p.expected.getValue(), DAYCOUNT_CONVENTION_OFFSET)
    }

    private fun parameter(): Array<Any> = definitionSample()

    companion object {
        val DAYCOUNT_CONVENTION_OFFSET = Offset.offset(1e-13)
        val LEAP_YEAR = 2016
        val REGULAR_YEAR = 2015
        val RATIO_365_360 = Fraction(365, 360)

        val LAST_TWO_WEEKS_LEAP_YEAR_FEB = interval(LEAP_YEAR, 2, 15, LEAP_YEAR, 2, 29)
        val LAST_TWO_WEEKS_REGULAR_YEAR_FEB = interval(REGULAR_YEAR, 2, 15, REGULAR_YEAR, 2, 28)
        val LAST_TWO_WEEKS_31_DAYS = interval(REGULAR_YEAR, 3, 15, REGULAR_YEAR, 3, 31)
        val LAST_TWO_WEEKS_30_DAYS = interval(REGULAR_YEAR, 4, 15, REGULAR_YEAR, 4, 30)
        val ONE_MONTH_LEAP_YEAR_FEB = interval(LEAP_YEAR, 2, 3)
        val ONE_MONTH_REGULAR_YEAR_FEB = interval(REGULAR_YEAR, 2, 3)
        val ONE_MONTH_AND_A_HALF_LEAP_YEAR_FEB = interval(LEAP_YEAR, 2, 1, LEAP_YEAR, 3, 15)
        val ONE_MONTH_AND_A_HALF_REGULAR_YEAR_FEB = interval(REGULAR_YEAR, 2, 1, REGULAR_YEAR, 3, 15)
        val TWO_MONTH_LEAP_YEAR_FEB = interval(LEAP_YEAR, 2, 4)
        val TWO_MONTH_REGULAR_YEAR_FEB = interval(REGULAR_YEAR, 2, 4)
        val ONE_QUARTER_LEAP_YEAR = interval(LEAP_YEAR, 1, 4)
        val ONE_QUARTER_REGULAR_YEAR = interval(REGULAR_YEAR, 1, 4)
        val ONE_SEMI_LEAP_YEAR = interval(LEAP_YEAR, 1, 7)
        val ONE_SEMI_REGULAR_YEAR = interval(REGULAR_YEAR, 1, 7)
        val ONE_LEAP_YEAR = oneYearInterval(LEAP_YEAR)
        val ONE_REGULAR_YEAR = oneYearInterval(REGULAR_YEAR)
    }

    protected fun dividePer366(numerator: Int): Fraction = dividePer(numerator, 366)
    protected fun dividePer365(numerator: Int): Fraction = dividePer(numerator, 365)
    protected fun dividePer360(numerator: Int): Fraction = dividePer(numerator, 360)
    private fun dividePer(numerator: Int, denominator: Int): Fraction = Fraction(numerator, denominator)

}