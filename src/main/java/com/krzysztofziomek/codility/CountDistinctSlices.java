package com.krzysztofziomek.codility;

/**
 * @author Krzysztof Ziomek
 * @since 29/04/2017.
 */
public class CountDistinctSlices {


    public int solution(int M, int[] A) {
        int back = 0;
        boolean[] seen = new boolean[M + 1];
        int total = 0;
        int MAX = 1000000000;

        for (int front = 0; front < A.length; front++) {
            if (seen[A[front]]) {
                do {
                    seen[A[back]] = false;
                    back++;
                } while (seen[A[front]]);
            }
            total += front - back + 1;
            seen[A[front]] = true;
            if (total >= MAX) {
                return MAX;
            }
        }
        return total;
    }

}
