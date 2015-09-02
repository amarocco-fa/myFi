package com.amo.tutorial.myFi.common.daycount

import java.time.LocalDate

class ISDA30360 : Method30360() {

    /*  public double calculateDayCountFraction(LocalDate from, LocalDate to, LocalDate maturity) {
  
          if (from.isEqual(to)) {
              return 0;
          }
          int dayOfMonth1 = from.getDayOfMonth();
          int dayOfMonth2 = to.getDayOfMonth();
          int month1 = from.getMonthOfYear();
          int month2 = to.getMonthOfYear();
          int year1 = from.getYear();
          int year2 = to.getYear();
  
          boolean isLastDayOfMonth = dayOfMonth1 == from.dayOfMonth().getMaximumValue();
          boolean isLastDayOfMonth2 = dayOfMonth2 == to.dayOfMonth().getMaximumValue();
  
          if (isLastDayOfMonth) {
              dayOfMonth1 = 30;
          }
  
          if ((isLastDayOfMonth2 && month2 != DateTimeConstants.FEBRUARY) || !to.isEqual(maturity)) {
              dayOfMonth2 = 30;
          }
  
          return getFactor(year1, year2, month1, month2, dayOfMonth1, dayOfMonth2);
      }*/

    protected override fun dayOfMonth(from: LocalDate, to: LocalDate): Int {
        var dayOfMonth1 = from.getDayOfMonth()
        var dayOfMonth2 = to.getDayOfMonth()

        val isLastDayOfMonth = dayOfMonth1 == from.lengthOfMonth();
        val isLastDayOfMonth2 = dayOfMonth2 == to.lengthOfMonth();

        if (isLastDayOfMonth) {
            dayOfMonth1 = 30;
        }

        if (isLastDayOfMonth2) {
            dayOfMonth2 = 30;
        }
        return dayOfMonth2 - dayOfMonth1;
    }

}