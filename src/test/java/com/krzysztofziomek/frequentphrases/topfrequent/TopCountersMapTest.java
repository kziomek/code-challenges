package com.krzysztofziomek.frequentphrases.topfrequent;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Krzysztof Ziomek
 * @since 18/03/2017.
 */
public class TopCountersMapTest {

    @Test
    public void topCounterShouldStayInMapWhenFirst() {
        // prepare
        TopCountersMap topCountersMap = new TopCountersMap(1);

        // execute
        topCountersMap.add(4L);
        topCountersMap.add(3L);
        topCountersMap.add(2L);

        // assert
        assertEquals(new Long(4), topCountersMap.getLowestCounter());
        assertEquals(1, topCountersMap.getLowestCounterFreeSlots());
    }

    @Test
    public void topCounterShouldStayInMapWhenInTheMiddle() {
        // prepare
        TopCountersMap topCountersMap = new TopCountersMap(1);

        // execute
        topCountersMap.add(2L);
        topCountersMap.add(3L);
        topCountersMap.add(2L);

        // assert
        assertEquals(new Long(3), topCountersMap.getLowestCounter());
        assertEquals(1, topCountersMap.getLowestCounterFreeSlots());
    }

    @Test
    public void topCounterShouldStayInMapWhenLast() {
        // prepare
        TopCountersMap topCountersMap = new TopCountersMap(1);

        // execute
        topCountersMap.add(1L);
        topCountersMap.add(1L);
        topCountersMap.add(2L);

        // assert
        assertEquals(new Long(2), topCountersMap.getLowestCounter());
        assertEquals(1, topCountersMap.getLowestCounterFreeSlots());
    }

    @Test
    public void mapShouldContain1AsLowestCounterAnd1FreeSlots() {

        TopCountersMap topCountersMap = new TopCountersMap(3);
        topCountersMap.add(1L);
        topCountersMap.add(1L);
        topCountersMap.add(2L);
        topCountersMap.add(2L);

        // assert
        assertEquals(new Long(1), topCountersMap.getLowestCounter());
        assertEquals(1, topCountersMap.getLowestCounterFreeSlots());
    }

    @Test
    public void mapShouldContain2AsLowestCounterAnd3FreeSlotsWhen3Counters2() {

        TopCountersMap topCountersMap = new TopCountersMap(3);
        topCountersMap.add(1L);
        topCountersMap.add(1L);
        topCountersMap.add(2L);
        topCountersMap.add(2L);
        topCountersMap.add(2L);

        // assert
        assertEquals(new Long(2), topCountersMap.getLowestCounter());
        assertEquals(3, topCountersMap.getLowestCounterFreeSlots());
    }

    @Test
    public void mapShouldContain2AsLowestCounterAnd3FreeSlotsWhen4Counters2() {

        TopCountersMap topCountersMap = new TopCountersMap(3);
        topCountersMap.add(1L);
        topCountersMap.add(1L);
        topCountersMap.add(2L);
        topCountersMap.add(2L);
        topCountersMap.add(2L);
        topCountersMap.add(2L);

        // assert
        assertEquals(new Long(2), topCountersMap.getLowestCounter());
        assertEquals(3, topCountersMap.getLowestCounterFreeSlots());
    }

}