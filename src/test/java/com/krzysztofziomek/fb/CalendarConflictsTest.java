package com.krzysztofziomek.fb;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author Krzysztof Ziomek
 * @since 30/04/2017.
 */
public class CalendarConflictsTest {

    @Test
    public void noConflictInOneElementCalendar() {
        int[][] calendar = new int[][]{
                {1, 2, 'a'}
        };

        int[][] conflicts = new CalendarConflicts().findConflicts(calendar);

        Assert.assertNull(conflicts[0]);

    }

    @Test
    public void testCallendarWithConflicts() {
        int[][] calendar = new int[][]{
                {1, 2, 'a'},
                {3, 5, 'b'},
                {4, 6, 'c'},
                {7, 10, 'd'},
                {8, 11, 'e'},
                {10, 12, 'f'},
                {13, 14, 'g'},
                {13, 14, 'h'}
        };

        int[][] conflicts = new CalendarConflicts().findConflicts(calendar);

        calendar[0] = null;
        assertArrayEquals(calendar, conflicts);

    }

    @Test
    public void testCallendarWithoutConflicts(){
        int[][] calendar = new int[][]{
                {1, 2, 'a'},
                {3, 5, 'b'},
                {7, 10, 'd'},
                {13, 14, 'g'}
        };

        int[][] conflicts = new CalendarConflicts().findConflicts(calendar);

        calendar[0] = null;
        calendar[1] = null;
        calendar[2] = null;
        calendar[3] = null;
        assertArrayEquals(calendar, conflicts);
    }

    @Test
    public void testCallendarWithSubElement(){
        int[][] calendar = new int[][]{
                {5, 6, 'a'},
                {10, 14, 'b'},
                {11, 12, 'c'},
                {12, 13, 'd'},
                {14, 15, 'e'}
        };

        int[][] conflicts = new CalendarConflicts().findConflicts(calendar);

        calendar[0] = null;
        calendar[4] = null;
        assertArrayEquals(calendar, conflicts);
    }



}