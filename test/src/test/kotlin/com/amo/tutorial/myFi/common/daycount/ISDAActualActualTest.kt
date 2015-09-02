package com.amo.tutorial.myFi.common.daycount

import com.amo.tutorial.interval
import com.amo.tutorial.myFi.common.DaycountConvention
import com.amo.tutorial.plus
import junitparams.JUnitParamsRunner
import org.junit.runner.RunWith

@RunWith(JUnitParamsRunner::class)
class ISDAActualActualTest : AbstractDaycountTest(DaycountConvention.ISDAActualActual) {

    override fun definitionSample(): kotlin.Array<kotlin.Any> = JUnitParamsRunner.`$`(
            JUnitParamsRunner.`$`(AbstractDaycountTest.LAST_TWO_WEEKS_LEAP_YEAR_FEB, dividePer366(14)),
            JUnitParamsRunner.`$`(AbstractDaycountTest.LAST_TWO_WEEKS_REGULAR_YEAR_FEB, dividePer365(13)),
            JUnitParamsRunner.`$`(AbstractDaycountTest.LAST_TWO_WEEKS_30_DAYS, dividePer365(15)),
            JUnitParamsRunner.`$`(AbstractDaycountTest.LAST_TWO_WEEKS_31_DAYS, dividePer365(16)),
            JUnitParamsRunner.`$`(AbstractDaycountTest.ONE_MONTH_LEAP_YEAR_FEB, dividePer366(29)),
            JUnitParamsRunner.`$`(AbstractDaycountTest.ONE_MONTH_REGULAR_YEAR_FEB, dividePer365(28)),
            JUnitParamsRunner.`$`(AbstractDaycountTest.ONE_MONTH_AND_A_HALF_LEAP_YEAR_FEB, dividePer366(29 + 14)),
            JUnitParamsRunner.`$`(AbstractDaycountTest.ONE_MONTH_AND_A_HALF_REGULAR_YEAR_FEB, dividePer365(28 + 14)),
            JUnitParamsRunner.`$`(AbstractDaycountTest.TWO_MONTH_LEAP_YEAR_FEB, dividePer366(29 + 31)),
            JUnitParamsRunner.`$`(AbstractDaycountTest.TWO_MONTH_REGULAR_YEAR_FEB, dividePer365(28 + 31)),
            JUnitParamsRunner.`$`(AbstractDaycountTest.ONE_QUARTER_LEAP_YEAR, dividePer366(31 + 29 + 31)),
            JUnitParamsRunner.`$`(AbstractDaycountTest.ONE_QUARTER_REGULAR_YEAR, dividePer365(31 + 28 + 31)),
            JUnitParamsRunner.`$`(AbstractDaycountTest.ONE_SEMI_LEAP_YEAR, dividePer366(31 + 29 + 31 + 30 + 31 + 30)),
            JUnitParamsRunner.`$`(AbstractDaycountTest.ONE_SEMI_REGULAR_YEAR, dividePer365(31 + 28 + 31 + 30 + 31 + 30)),
            JUnitParamsRunner.`$`(AbstractDaycountTest.ONE_LEAP_YEAR, dividePer366(366)),
            JUnitParamsRunner.`$`(AbstractDaycountTest.ONE_REGULAR_YEAR, dividePer365(365)),

            //More than One Year
            JUnitParamsRunner.`$`(interval(AbstractDaycountTest.REGULAR_YEAR, 1, 31, AbstractDaycountTest.REGULAR_YEAR + 4, 3, 31), 3 + dividePer365(335) + dividePer365(89)),
            JUnitParamsRunner.`$`(interval(AbstractDaycountTest.LEAP_YEAR, 1, 31, AbstractDaycountTest.LEAP_YEAR + 4, 3, 31), 3 + dividePer366(336) + dividePer366(90)),
            JUnitParamsRunner.`$`(interval(AbstractDaycountTest.REGULAR_YEAR, 1, 31, AbstractDaycountTest.LEAP_YEAR, 3, 31), dividePer365(335) + dividePer366(90)),
            JUnitParamsRunner.`$`(interval(AbstractDaycountTest.LEAP_YEAR, 1, 31, AbstractDaycountTest.LEAP_YEAR + 3, 3, 31), 2 + dividePer366(336) + dividePer365(89))
    )

}