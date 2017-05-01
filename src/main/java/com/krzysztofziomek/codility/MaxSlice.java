package com.krzysztofziomek.codility;

/**
 * @author Krzysztof Ziomek
 * @since 30/04/2017.
 */
class MaxSlice {

    public int solution(int[] A) {
        int slice = A[0];
        int maxSlice = A[0];

        for (int i = 1; i < A.length; i++) {
            slice = A[i] + (slice >= 0 ? slice : 0);
            if (slice > maxSlice) {
                maxSlice = slice;
            }
        }

        return maxSlice;
    }

}