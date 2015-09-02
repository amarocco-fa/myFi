package com.amo.tutorial.myFi.common.daycount

import com.amo.tutorial.interval
import com.amo.tutorial.myFi.common.DaycountConvention
import com.amo.tutorial.plus
import junitparams.JUnitParamsRunner
import org.junit.Ignore
import org.junit.runner.RunWith

@Ignore
@RunWith(JUnitParamsRunner::class)
class AFBActualActualTest : AbstractDaycountTest(/*DaycountConvention.AFBActualActual*/DaycountConvention._30365) {

    override fun definitionSample(): kotlin.Array<kotlin.Any> = JUnitParamsRunner.`$`(
            JUnitParamsRunner.`$`(AbstractDaycountTest.LAST_TWO_WEEKS_LEAP_YEAR_FEB, dividePer365(14)),
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
            /**
             * Examples based on wikipedia
             * <p/>
             * From 1994-02-10 to 1997-06-30    3 + 140 / 365
             * <p/>
             * Date range                       ISDA count back rule 	Simple count back rule
             * From 2004-02-28 to 2008-02-27 	3 + 365 / 366           3 + 365 / 366
             * From 2004-02-28 to 2008-02-28 	4 + 1 / 366 	        4
             * From 2004-02-28 to 2008-02-29 	4 + 1 / 366 	        4 + 1 / 366
             */
            JUnitParamsRunner.`$`(interval(1994, 2, 10, 1997, 6, 30), 3 + dividePer365(140)),
            JUnitParamsRunner.`$`(interval(2004, 2, 28, 2008, 2, 27), 3 + dividePer366(365)),
            JUnitParamsRunner.`$`(interval(2004, 2, 28, 2008, 2, 28), 4 + dividePer366(1)),
            JUnitParamsRunner.`$`(interval(2004, 2, 28, 2008, 2, 29), 4 + dividePer366(1))
    )

}