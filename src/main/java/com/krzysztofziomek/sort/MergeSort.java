package com.krzysztofziomek.sort;

import java.util.Arrays;

/**
 * @author Krzysztof Ziomek
 * @since 01/04/2017.
 */
public class MergeSort {


    private void mergeSort(int[] A, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(A, p, q);
            mergeSort(A, q + 1, r);
            merge(A, p, q, r);
        }
    }

    private void merge(int A[], int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] L = new int[n1 + 1];
        int[] R = new int[n2 + 1];
        int santiel = 0;

        for (int i = 0; i < n1; i++) {
            L[i] = A[p + i];
            if (L[i] >= santiel) {
                santiel = L[i] + 1;
            }
        }

        for (int j = 0; j < n2; j++) {
            R[j] = A[q + j + 1];
            if (R[j] >= santiel) {
                santiel = R[j] + 1;
            }
        }
        L[n1] = santiel;
        R[n2] = santiel;

        int i = 0;
        int j = 0;

        for (int k = p; k <= r; k++) {
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i++;
            } else {
                A[k] = R[j];
                j++;
            }
        }

    }


    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] A = {24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12};
        System.out.println(Arrays.toString(A));
        mergeSort.mergeSort(A, 0, A.length - 1);
        System.out.println(Arrays.toString(A));
    }

}
