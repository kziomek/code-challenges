package com.krzysztofziomek.search;

/**
 * @author Krzysztof Ziomek
 * @since 01/08/2021.
 */
public class QuickSelect {

    public int kthSmallest(int[] arr, int k) {
        return quickselect(arr, 0, arr.length - 1, k);
    }

    int quickselect(int[] arr, int lo, int hi, int k) {
        int partitionIdx = partition(arr, lo, hi);
        if (partitionIdx + 1 == k) {
            return arr[partitionIdx];
        } else if (partitionIdx + 1 > k) {
            return quickselect(arr, lo, partitionIdx - 1, k);
        } else {
            return quickselect(arr, partitionIdx + 1, hi, k);
        }
    }

    int partition(int[] A, int lo, int hi) {
        int pivot = A[hi];
        int p = lo - 1;
        for (int i = lo; i < hi; i++) {
            if (A[i] <= pivot) {
                p++;
                swap(A, i, p);
            }
        }
        swap(A, ++p, hi);
        return p;
    }

    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
