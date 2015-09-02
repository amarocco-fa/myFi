package com.amo.tutorial.myFi.common.daycount

import com.amo.tutorial.interval
import com.amo.tutorial.myFi.common.DaycountConvention
import junitparams.JUnitParamsRunner
import org.junit.runner.RunWith

@RunWith(JUnitParamsRunner::class)
class Belgian360Test : AbstractDaycountTest(DaycountConvention.BE_360) {

    override fun definitionSample(): kotlin.Array<kotlin.Any> = JUnitParamsRunner.`$`(
            JUnitParamsRunner.`$`(AbstractDaycountTest.LAST_TWO_WEEKS_LEAP_YEAR_FEB, dividePer360(14)),
            JUnitParamsRunner.`$`(AbstractDaycountTest.LAST_TWO_WEEKS_REGULAR_YEAR_FEB, dividePer360(13)),
            JUnitParamsRunner.`$`(AbstractDaycountTest.LAST_TWO_WEEKS_30_DAYS, dividePer360(15)),
            JUnitParamsRunner.`$`(AbstractDaycountTest.LAST_TWO_WEEKS_31_DAYS, dividePer360(16)),
            JUnitParamsRunner.`$`(AbstractDaycountTest.ONE_MONTH_LEAP_YEAR_FEB, dividePer360(29)),
            JUnitParamsRunner.`$`(AbstractDaycountTest.ONE_MONTH_REGULAR_YEAR_FEB, dividePer360(28)),
            JUnitParamsRunner.`$`(AbstractDaycountTest.ONE_MONTH_AND_A_HALF_LEAP_YEAR_FEB, dividePer360(29 + 14)),
            JUnitParamsRunner.`$`(AbstractDaycountTest.ONE_MONTH_AND_A_HALF_REGULAR_YEAR_FEB, dividePer360(28 + 14)),
            JUnitParamsRunner.`$`(AbstractDaycountTest.TWO_MONTH_LEAP_YEAR_FEB, dividePer360(29 + 31)),
            JUnitParamsRunner.`$`(AbstractDaycountTest.TWO_MONTH_REGULAR_YEAR_FEB, dividePer360(28 + 31)),
            JUnitParamsRunner.`$`(AbstractDaycountTest.ONE_QUARTER_LEAP_YEAR, dividePer360(31 + 29 + 31)),
            JUnitParamsRunner.`$`(AbstractDaycountTest.ONE_QUARTER_REGULAR_YEAR, dividePer360(31 + 28 + 31)),
            JUnitParamsRunner.`$`(AbstractDaycountTest.ONE_SEMI_LEAP_YEAR, dividePer360(31 + 29 + 31 + 30 + 31 + 30)),
            JUnitParamsRunner.`$`(AbstractDaycountTest.ONE_SEMI_REGULAR_YEAR, dividePer360(31 + 28 + 31 + 30 + 31 + 30)),
            JUnitParamsRunner.`$`(AbstractDaycountTest.ONE_LEAP_YEAR, dividePer360(366)),
            JUnitParamsRunner.`$`(AbstractDaycountTest.ONE_REGULAR_YEAR, dividePer360(365)),

            JUnitParamsRunner.`$`(interval(AbstractDaycountTest.LEAP_YEAR, 12, 31, AbstractDaycountTest.LEAP_YEAR + 1, 1, 31), dividePer360(31 - 1)),
            JUnitParamsRunner.`$`(interval(AbstractDaycountTest.LEAP_YEAR, 12, 1, AbstractDaycountTest.LEAP_YEAR, 12, 31), dividePer360(30 + 1))
    )

}