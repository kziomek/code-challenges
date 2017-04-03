package com.krzysztofziomek.sort;

import java.util.Arrays;

/**
 * @author Krzysztof Ziomek
 * @since 03/04/2017.
 */
public class InsertionSort {

    private void sort(int[] A) {
        for (int j = 1; j < A.length; j++) {
            int k = A[j];
            int i = j - 1;

            while (i >= 0 && A[i] > k) {
                A[i + 1] = A[i];
                i--;
            }
            A[i + 1] = k;
        }
    }

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        int[] A = new int[]{5, 2, 4, 6, 1, 3};
        System.out.println(Arrays.toString(A));
        insertionSort.sort(A);
        System.out.println(Arrays.toString(A));
    }
}
