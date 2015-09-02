package com.amo.tutorial.myFi.common.daycount

import com.amo.tutorial.interval
import com.amo.tutorial.myFi.common.DaycountConvention
import junitparams.JUnitParamsRunner
import org.junit.runner.RunWith

@RunWith(JUnitParamsRunner::class)
class ISDA30360Test : AbstractDaycountTest(DaycountConvention.ISDA30360) {

    override fun definitionSample(): kotlin.Array<kotlin.Any> = JUnitParamsRunner.`$`(
            JUnitParamsRunner.`$`(AbstractDaycountTest.LAST_TWO_WEEKS_LEAP_YEAR_FEB, dividePer360(15)),
            JUnitParamsRunner.`$`(AbstractDaycountTest.LAST_TWO_WEEKS_REGULAR_YEAR_FEB, dividePer360(15)),
            JUnitParamsRunner.`$`(AbstractDaycountTest.LAST_TWO_WEEKS_30_DAYS, dividePer360(15)),
            JUnitParamsRunner.`$`(AbstractDaycountTest.LAST_TWO_WEEKS_31_DAYS, dividePer360(15)),
            JUnitParamsRunner.`$`(AbstractDaycountTest.ONE_MONTH_LEAP_YEAR_FEB, dividePer360(30)),
            JUnitParamsRunner.`$`(AbstractDaycountTest.ONE_MONTH_REGULAR_YEAR_FEB, dividePer360(30)),
            JUnitParamsRunner.`$`(AbstractDaycountTest.ONE_MONTH_AND_A_HALF_LEAP_YEAR_FEB, dividePer360(30 + 14)),
            JUnitParamsRunner.`$`(AbstractDaycountTest.ONE_MONTH_AND_A_HALF_REGULAR_YEAR_FEB, dividePer360(30 + 14)),
            JUnitParamsRunner.`$`(AbstractDaycountTest.TWO_MONTH_LEAP_YEAR_FEB, dividePer360(30 + 30)),
            JUnitParamsRunner.`$`(AbstractDaycountTest.TWO_MONTH_REGULAR_YEAR_FEB, dividePer360(30 + 30)),
            JUnitParamsRunner.`$`(AbstractDaycountTest.ONE_QUARTER_LEAP_YEAR, dividePer360(30 + 30 + 30)),
            JUnitParamsRunner.`$`(AbstractDaycountTest.ONE_QUARTER_REGULAR_YEAR, dividePer360(30 + 30 + 30)),
            JUnitParamsRunner.`$`(AbstractDaycountTest.ONE_SEMI_LEAP_YEAR, dividePer360(30 + 30 + 30 + 30 + 30 + 30)),
            JUnitParamsRunner.`$`(AbstractDaycountTest.ONE_SEMI_REGULAR_YEAR, dividePer360(30 + 30 + 30 + 30 + 30 + 30)),
            JUnitParamsRunner.`$`(AbstractDaycountTest.ONE_LEAP_YEAR, dividePer360(360)),
            JUnitParamsRunner.`$`(AbstractDaycountTest.ONE_REGULAR_YEAR, dividePer360(360)),

            JUnitParamsRunner.`$`(interval(AbstractDaycountTest.REGULAR_YEAR, 2, 1, AbstractDaycountTest.REGULAR_YEAR, 2, 28), dividePer360(29)),
            JUnitParamsRunner.`$`(interval(AbstractDaycountTest.LEAP_YEAR, 2, 1, AbstractDaycountTest.LEAP_YEAR, 2, 29), dividePer360(29)),

            JUnitParamsRunner.`$`(interval(AbstractDaycountTest.REGULAR_YEAR, 2, 28, AbstractDaycountTest.REGULAR_YEAR, 3, 31), dividePer360(30)),
            JUnitParamsRunner.`$`(interval(AbstractDaycountTest.LEAP_YEAR, 2, 29, AbstractDaycountTest.LEAP_YEAR, 3, 31), dividePer360(30)),
            JUnitParamsRunner.`$`(interval(AbstractDaycountTest.LEAP_YEAR, 2, 28, AbstractDaycountTest.LEAP_YEAR, 3, 31), dividePer360(32))
    )

}