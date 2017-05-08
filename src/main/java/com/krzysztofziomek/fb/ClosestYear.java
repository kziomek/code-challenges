package com.krzysztofziomek.fb;

import java.util.Calendar;

/**
 * @author Krzysztof Ziomek
 * @since 08/05/2017.
 */
public class ClosestYear {

    public int getClosestYear(int twoDigits) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int currentLast2digits = currentYear % 100;

        if (twoDigits >= currentLast2digits + 50) {
            return currentYear - currentLast2digits - 100 + twoDigits;
        } else {
            return currentYear - currentLast2digits + twoDigits;
        }

    }

}
