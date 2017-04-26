package com.krzysztofziomek.codility;

/**
 * @author Krzysztof Ziomek
 * @since 26/04/2017.
 */
public class MaxCounters {

    public int[] solution(int N, int[] A) {
        int[] counters = new int[N];
        int max = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == N + 1) {
                for (int j = 0; j < N; j++) {
                    counters[j] = max;
                }
            } else {
                counters[A[i] - 1]++;
                if (counters[A[i] - 1] > max) {
                    max = counters[A[i] - 1];
                }
            }
        }

        return counters;
    }


}
