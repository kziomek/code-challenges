package com.krzysztofziomek.sort;

import java.util.Arrays;

/**
 * @author Krzysztof Ziomek
 * @since 01/04/2017.
 * Introduction to Algorithms, p. 160
 */
public class HoarePartition {


    public static void main(String[] args) {
        HoarePartition hoarePartition = new HoarePartition();
        int[] A = {13, 19, 9, 5, 12, 8, 7, 4, 11, 2, 6, 21};
        System.out.println(Arrays.toString(A));
        int j = hoarePartition.partition(A, 0, A.length - 1);
        System.out.println(Arrays.toString(A));
        System.out.println("Partition idx is: " + j);
    }

    private int partition(int[] A, int p, int r) {
        int x = A[p];
        int i = p - 1;
        int j = r + 1;
        while (true) {
            while (!(A[--j] <= x));
            while (!(A[++i] >= x));
            if (i < j) {
                swap(A, i, j);
            } else {
                return j;
            }
        }
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }


}
