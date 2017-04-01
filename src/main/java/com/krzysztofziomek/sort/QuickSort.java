package com.krzysztofziomek.sort;

/**
 * @author Krzysztof Ziomek
 * @since 01/04/2017.
 * https://en.wikipedia.org/wiki/Quicksort
 */
public class QuickSort {

    private void quicksort(int[] A, int lo, int hi) {
        if (lo < hi) {
            int p = partition(A, lo, hi);
            quicksort(A, lo, p - 1);
            quicksort(A, p + 1, hi);
        }
    }

    private int partition(int[] A, int lo, int hi) {
        int pivot = A[hi];
        int i = lo - 1;
        for (int j = lo; j < hi; j++) {
            if (A[j] <= pivot) {
                i++;
                swap(A, i, j);
            }
        }
        swap(A, i + 1, hi);
        return ++i;
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] A = {24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12};
        quickSort.print(A);
        quickSort.quicksort(A, 0, A.length - 1);
        quickSort.print(A);

    }

    private void print(int[] A) {
        System.out.println();
        for (int a : A) {
            System.out.print(a + " ");
        }
    }
}
