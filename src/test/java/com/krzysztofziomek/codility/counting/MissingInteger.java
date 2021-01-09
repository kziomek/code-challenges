package com.krzysztofziomek.codility.counting;

/**
 * @author Krzysztof Ziomek
 * @since 09/01/2021.
 */
public class MissingInteger {
    public int solution(int[] A) {
        int m = A.length;
        boolean[] c = new boolean[m + 1];
        for (int a : A) {
            if (a > 0 && a <= m) {
                c[a] = true;
            }
        }
        for (int i = 1; i < c.length; i++) {
            if (!c[i]) {
                return i;
            }
        }
        return m + 1;
    }
}