package com.krzysztofziomek.dynamic;

import java.util.Arrays;

/**
 * @author Krzysztof Ziomek
 * @since 08/05/2017.
 */

class Job {
    int start;
    int end;
    int profit;

    public Job(int start, int end, int profit) {
        this.start = start;
        this.end = end;
        this.profit = profit;
    }
}

public class WeightedJobScheduling {


    public int maxProfit(Job[] jobs) {
        Arrays.sort(jobs, (i, j) -> i.end - j.end);
        int[] T = new int[jobs.length];
        T[0] = jobs[0].profit;

        for (int i = 1; i < jobs.length; i++) {
            T[i] = jobs[i].profit;
            for (int j = 0; j < i; j++) {
                if (jobs[j].end <= jobs[i].start) {
                    T[i] = Math.max(T[i], jobs[i].profit + T[j]);
                }
            }
        }

        int maxProfit = T[0];
        for (int i = 1; i < T.length; i++) {
            maxProfit = Math.max(maxProfit, T[i]);
        }

        return maxProfit;

    }

}
