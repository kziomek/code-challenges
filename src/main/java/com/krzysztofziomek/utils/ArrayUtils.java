package com.krzysztofziomek.utils;

/**
 * @author Krzysztof Ziomek
 * @since 25/04/2017.
 */
public class ArrayUtils {

    public static void exchange(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
