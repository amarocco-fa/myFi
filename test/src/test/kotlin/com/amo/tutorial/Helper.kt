package com.amo.tutorial

import com.amo.tutorial.myFi.common.Fraction
import com.amo.tutorial.myFi.common.Interval
import java.time.LocalDate

val PORTFOLIO_START_DATE = LocalDate.of(2010, 4, 23)
val PORTFOLIO_MATURITY_DATE = LocalDate.of(2020, 2, 28)
/*
val CHF = Currency.getInstance("CHF")
val EUR = Currency.getInstance("EUR")
val GBP = Currency.getInstance("GBP")
val JPY = Currency.getInstance("JPY")
val USD = Currency.getInstance("USD")

val CLIENT = Client(
        id = 1,
        name = "GLO CORPO"
)
*/
val BNP = "BNP"
val SG = "SG"

fun oneYearInterval(year: Int): Interval = interval(year, 1, 1, year + 1, 1, 1)
fun interval(year: Int, fromMonth: Int, toMonth: Int): Interval = interval(year, fromMonth, 1, year, toMonth, 1)
fun interval(fromYear: Int, fromMonth: Int, fromDay: Int, toYear: Int, toMonth: Int, toDay: Int): Interval = Interval(LocalDate.of(fromYear, fromMonth, fromDay), LocalDate.of(toYear, toMonth, toDay))

fun Int.plus(f: Fraction): Fraction = f.plus(this, 1)