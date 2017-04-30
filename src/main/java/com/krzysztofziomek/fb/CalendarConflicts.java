package com.krzysztofziomek.fb;

/**
 * @author Krzysztof Ziomek
 * @since 30/04/2017.
 * <p>
 * https://www.youtube.com/watch?v=olK6SWl8UrM
 */
public class CalendarConflicts {

    public int[][] findConflicts(int[][] calendar) {
        int[][] conflicts = new int[calendar.length][];

        int end = calendar[0][1];
        for (int i = 1; i < calendar.length; i++) {

            if (end > calendar[i][0]) {
                conflicts[i - 1] = calendar[i - 1];
                conflicts[i] = calendar[i];
            }
            end = Math.max(end, calendar[i][1]);
        }

        return conflicts;
    }

}
