package com.krzysztofziomek.codility;

/**
 * @author Krzysztof Ziomek
 * @since 08/01/2021.
 * <p>
 * Prefix sums. Codility. Lesson 5
 */
public class Mashrooms {

    public int solution(int[] A, int k, int m) {
        int[] pref = prefix_sum(A);
        int l, r, max = 0;
        //go left
        for (int i = 1; i <= Math.min(m, k); i++) {
            l = k - i;
            r = Math.min(A.length - 1, k + Math.max(0, m - 2 * i));
            max = Math.max(max, pref[r + 1] - pref[l]);
        }

        //go right
        for (int i = 1; i <= Math.min(m, A.length - k - 1); i++) {
            r = k + i;
            l = Math.max(0, k - Math.max(0, m - 2 * i));
            max = Math.max(max, pref[r + 1] - pref[l]);
        }
        return max;
    }

    private int[] prefix_sum(int[] A) {
        int[] pref = new int[A.length + 1];
        pref[0] = 0;
        for (int i = 1; i < pref.length; i++) {
            pref[i] = pref[i - 1] + A[i - 1];
        }
        return pref;
    }
}
