package com.amo.tutorial.myFi.common.daycount

import java.time.LocalDate
import java.time.Month

class Belgian30360 : Method30360() {

    /**
     * si une échéance commence le 31/12 =>  nombre de jour dans la base de taux belge = (date début échéance - date fin échéance) -1<br/>
     * si une échéance se termine le 31/12 => nombre de jour dans la base de taux belge = (date début échéance - date fin échéance) +1
     *
     */
    protected override fun dayOfMonth(from: LocalDate, to: LocalDate): Int {
        var dayGap: Int
        var dayOfMonth1 = if (from.getDayOfMonth() == 31 ) 30 else from.getDayOfMonth()
        var dayOfMonth2 = if (to.getDayOfMonth() == 31) 30 else to.getDayOfMonth()

        if (from.getMonth() == Month.FEBRUARY && to.getMonth() == Month.FEBRUARY) {
            dayGap = dayOfMonth2 - dayOfMonth1;

            if (dayOfMonth1 == 1 && DaycountCalculator.isLastDayOfFebruary(to)) {
                dayGap = 30; // Les mois font 30 jours
            }
        } else {
            if (from.getMonth() == Month.FEBRUARY) {
                if (DaycountCalculator.isLastDayOfFebruary(from)) {
                    dayOfMonth1 = 30; // Nous sommes sur le dernier jour du mois (cf. convention)
                } else if (dayOfMonth1 == 28) {
                    dayOfMonth1 = 29; // Pour conserver la cohérence dans le nombre de jours (cf. convention fin de mois au 30)
                }
            } else if (to.getMonth() == Month.FEBRUARY) {
                if (DaycountCalculator.isLastDayOfFebruary(to)) {
                    dayOfMonth2 = 30; // Nous sommes sur le dernier jour du mois (cf. convention)
                } else if (dayOfMonth2 == 28) {
                    dayOfMonth2 = 29; // Pour conserver la cohérence dans le nombre de jours
                }
            }
            dayGap = dayOfMonth2 - dayOfMonth1;
        }

        if (DaycountCalculator.isLastDayOfDecember(from)) {
            dayGap--;
        }
        if (DaycountCalculator.isLastDayOfDecember(to)) {
            dayGap++;
        }
        return dayGap;
    }

}