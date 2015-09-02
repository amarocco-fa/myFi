package com.amo.tutorial.myFi.common.daycount

import com.amo.tutorial.myFi.common.DaycountConvention
import junitparams.JUnitParamsRunner
import org.junit.runner.RunWith

@RunWith(JUnitParamsRunner::class)
class _30365Test : AbstractDaycountTest(DaycountConvention._30365) {

    override fun definitionSample(): Array<Any> {
        return JUnitParamsRunner.`$`(
                JUnitParamsRunner.`$`(AbstractDaycountTest.LAST_TWO_WEEKS_LEAP_YEAR_FEB, dividePer365(14)),
                JUnitParamsRunner.`$`(AbstractDaycountTest.LAST_TWO_WEEKS_REGULAR_YEAR_FEB, dividePer365(13)),
                JUnitParamsRunner.`$`(AbstractDaycountTest.LAST_TWO_WEEKS_30_DAYS, dividePer365(15)),
                JUnitParamsRunner.`$`(AbstractDaycountTest.LAST_TWO_WEEKS_31_DAYS, dividePer365(15)),
                JUnitParamsRunner.`$`(AbstractDaycountTest.ONE_MONTH_LEAP_YEAR_FEB, dividePer365(30)),
                JUnitParamsRunner.`$`(AbstractDaycountTest.ONE_MONTH_REGULAR_YEAR_FEB, dividePer365(30)),
                JUnitParamsRunner.`$`(AbstractDaycountTest.ONE_MONTH_AND_A_HALF_LEAP_YEAR_FEB, dividePer365(30 + 14)),
                JUnitParamsRunner.`$`(AbstractDaycountTest.ONE_MONTH_AND_A_HALF_REGULAR_YEAR_FEB, dividePer365(30 + 14)),
                JUnitParamsRunner.`$`(AbstractDaycountTest.TWO_MONTH_LEAP_YEAR_FEB, dividePer365(30 + 30)),
                JUnitParamsRunner.`$`(AbstractDaycountTest.TWO_MONTH_REGULAR_YEAR_FEB, dividePer365(30 + 30)),
                JUnitParamsRunner.`$`(AbstractDaycountTest.ONE_QUARTER_LEAP_YEAR, dividePer365(30 + 30 + 30)),
                JUnitParamsRunner.`$`(AbstractDaycountTest.ONE_QUARTER_REGULAR_YEAR, dividePer365(30 + 30 + 30)),
                JUnitParamsRunner.`$`(AbstractDaycountTest.ONE_SEMI_LEAP_YEAR, dividePer365(30 + 30 + 30 + 30 + 30 + 30)),
                JUnitParamsRunner.`$`(AbstractDaycountTest.ONE_SEMI_REGULAR_YEAR, dividePer365(30 + 30 + 30 + 30 + 30 + 30)),
                JUnitParamsRunner.`$`(AbstractDaycountTest.ONE_LEAP_YEAR, dividePer365(360)),
                JUnitParamsRunner.`$`(AbstractDaycountTest.ONE_REGULAR_YEAR, dividePer365(360))
        )
    }

}