package com.krzysztofziomek.codility.dynamic;

import java.util.Arrays;

/**
 * @author Krzysztof Ziomek
 * @since 21/05/2017.
 */
public class NumberSolitaire {

    public int solution(int[] A) {

        int[] bestPath = new int[A.length];
        Arrays.fill(bestPath, Integer.MIN_VALUE);
        bestPath[0] = A[0];

        for (int i=1; i<A.length; i++){
            for (int dice = 1; dice<=6; dice++){
                if (i-dice>=0) {
                    bestPath[i] = Math.max(bestPath[i], A[i]+bestPath[i-dice]);
                }
            }
        }
        return bestPath[A.length-1];
    }
}
