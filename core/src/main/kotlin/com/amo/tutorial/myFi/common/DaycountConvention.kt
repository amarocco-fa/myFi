package com.amo.tutorial.myFi.common

import com.amo.tutorial.myFi.common.daycount.*
import java.time.LocalDate

enum class DaycountConvention(private val dayCount: DaycountCalculator) {

    BE30360(Constants.BE_30360),
    EU30360(Constants.EU_30360),
    US30360(Constants.US_30360),
    ISDA30360(Constants.ISDA_30360),
    Adjusted30360(Constants.ADJUSTED_30360),
    Actual360(Constants.ACTUAL_360),
    BE_360(Constants.BE_360),
    ISDAActualActual(Constants.ISDA_ACTUAL_ACTUAL),
    /*AFBActualActual(Constants.AFB_ACTUAL_ACTUAL),*/
    ActualActual(Constants.FA_ACTUAL_ACTUAL),
    BE_Actual(Constants.BE_ACTUAL),
    Actual365Fixed(Constants.ACTUAL_365_FIXED),
    BE_365(Constants.BE_365),
    _365_360(Constants._365_360),
    _30365(Constants._30365);

    fun getCalculator(): DaycountCalculator = dayCount
    fun daysBetween(from: LocalDate, to: LocalDate): Int = daysBetween(from, to, RangeDefinition.CLOSED)
    fun daysBetween(from: LocalDate, to: LocalDate, definition: RangeDefinition): Int = getCalculator().daysBetween(from, to, definition)
    fun calculateDaycountFractionAsDouble(from: LocalDate, to: LocalDate): Double = getCalculator().calculateDaycountFractionAsDouble(from, to)
    fun calculateDaycountFraction(from: LocalDate, to: LocalDate): Fraction = getCalculator().calculateDaycountFraction(from, to)
    fun calculateDaycountFraction(interval: Interval): Double = calculateDaycountFractionAsDouble(interval.getStart(), interval.getEnd())

    private class Constants {
        companion object {
            val BE_30360 = Belgian30360()
            val EU_30360 = com.amo.tutorial.myFi.common.daycount.EU30360()
            val US_30360 = com.amo.tutorial.myFi.common.daycount.US30360()
            val ISDA_30360 = com.amo.tutorial.myFi.common.daycount.ISDA30360()
            val ADJUSTED_30360 = com.amo.tutorial.myFi.common.daycount.Adjusted30360()
            val ACTUAL_360 = com.amo.tutorial.myFi.common.daycount.Actual360()
            val BE_360 = Belgian360()
            val ACTUAL_365_FIXED = com.amo.tutorial.myFi.common.daycount.Actual365Fixed()
            val BE_365 = Belgian365()
            val FA_ACTUAL_ACTUAL = FAActualActual()
            val AFB_ACTUAL_ACTUAL = AFBActualActual()
            val ISDA_ACTUAL_ACTUAL = com.amo.tutorial.myFi.common.daycount.ISDAActualActual()
            val BE_ACTUAL = BelgianActual()
            val _365_360 = _365360()
            val _30365 = com.amo.tutorial.myFi.common.daycount._30365()
        }
    }

}