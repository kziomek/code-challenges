package com.krzysztofziomek.codility;

import java.util.Arrays;

/**
 * @author Krzysztof Ziomek
 * @since 20/05/2017.
 */
public class MinAbsSumOfTwo {

    public int solution(int[] A) {
        Arrays.sort(A);
        int min = Integer.MAX_VALUE;
        int diff;

        int left = 0;
        int right = A.length - 1;


        while (left <= right) {
            diff = A[left] + A[right];
            if (diff == 0) {
                return 0;
            }
            if (diff > 0) {
                right--;

            } else {
                left++;
                diff = -diff;
            }
            min = Math.min(min, diff);

        }

        return min;

    }
}
