package com.amo.tutorial.myFi.common.daycount

import com.amo.tutorial.interval
import com.amo.tutorial.myFi.common.DaycountConvention
import junitparams.JUnitParamsRunner
import org.junit.runner.RunWith

@RunWith(JUnitParamsRunner::class)
class _365360Test : AbstractDaycountTest(DaycountConvention._365_360) {

    public override fun definitionSample(): Array<Any> = JUnitParamsRunner.`$`(
            JUnitParamsRunner.`$`(interval(2016, 1, 1, 2016, 4, 1), dividePer360(91 - 1)),
            JUnitParamsRunner.`$`(interval(2016, 3, 1, 2016, 6, 1), dividePer360(92)),
            JUnitParamsRunner.`$`(interval(2013, 1, 1, 2016, 4, 1), AbstractDaycountTest.RATIO_365_360.times(3).plus((91 - 1), 360)),
            JUnitParamsRunner.`$`(interval(2013, 1, 1, 2016, 4, 15), AbstractDaycountTest.RATIO_365_360.times(3).plus((105 - 1), 360)),
            JUnitParamsRunner.`$`(interval(2012, 1, 1, 2015, 4, 15), AbstractDaycountTest.RATIO_365_360.times(3).plus(104, 360)),
            JUnitParamsRunner.`$`(AbstractDaycountTest.LAST_TWO_WEEKS_LEAP_YEAR_FEB, dividePer360(14)),
            JUnitParamsRunner.`$`(AbstractDaycountTest.LAST_TWO_WEEKS_REGULAR_YEAR_FEB, dividePer360(13)),
            JUnitParamsRunner.`$`(AbstractDaycountTest.LAST_TWO_WEEKS_30_DAYS, dividePer360(15)),
            JUnitParamsRunner.`$`(AbstractDaycountTest.LAST_TWO_WEEKS_31_DAYS, dividePer360(16)),
            JUnitParamsRunner.`$`(AbstractDaycountTest.ONE_MONTH_LEAP_YEAR_FEB, dividePer360(28)),
            JUnitParamsRunner.`$`(AbstractDaycountTest.ONE_MONTH_REGULAR_YEAR_FEB, dividePer360(28)),
            JUnitParamsRunner.`$`(AbstractDaycountTest.ONE_MONTH_AND_A_HALF_LEAP_YEAR_FEB, dividePer360(42)),
            JUnitParamsRunner.`$`(AbstractDaycountTest.ONE_MONTH_AND_A_HALF_REGULAR_YEAR_FEB, dividePer360(42)),
            JUnitParamsRunner.`$`(AbstractDaycountTest.TWO_MONTH_LEAP_YEAR_FEB, dividePer360(59)),
            JUnitParamsRunner.`$`(AbstractDaycountTest.TWO_MONTH_REGULAR_YEAR_FEB, dividePer360(59)),
            JUnitParamsRunner.`$`(AbstractDaycountTest.ONE_QUARTER_LEAP_YEAR, dividePer360(90)),
            JUnitParamsRunner.`$`(AbstractDaycountTest.ONE_QUARTER_REGULAR_YEAR, dividePer360(90)),
            JUnitParamsRunner.`$`(AbstractDaycountTest.ONE_SEMI_LEAP_YEAR, dividePer360(181)),
            JUnitParamsRunner.`$`(AbstractDaycountTest.ONE_SEMI_REGULAR_YEAR, dividePer360(181)),
            JUnitParamsRunner.`$`(AbstractDaycountTest.ONE_LEAP_YEAR, AbstractDaycountTest.RATIO_365_360),
            JUnitParamsRunner.`$`(AbstractDaycountTest.ONE_REGULAR_YEAR, AbstractDaycountTest.RATIO_365_360)
    )

}