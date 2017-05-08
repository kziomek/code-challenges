package com.krzysztofziomek.dynamic;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Krzysztof Ziomek
 * @since 09/05/2017.
 */
public class WeightedJobSchedulingTest {

    @Test
    public void maxProfit() throws Exception {
        WeightedJobScheduling weightedJobScheduling = new WeightedJobScheduling();
        Job[] jobs = new Job[6];
        jobs[0] = new Job(2, 5, 6);
        jobs[1] = new Job(1, 3, 5);
        jobs[2] = new Job(4, 6, 5);
        jobs[3] = new Job(5, 8, 11);
        jobs[4] = new Job(7, 9, 2);
        jobs[5] = new Job(6, 7, 4);

        int profit = weightedJobScheduling.maxProfit(jobs);
        Assert.assertEquals(17, profit);

    }

}