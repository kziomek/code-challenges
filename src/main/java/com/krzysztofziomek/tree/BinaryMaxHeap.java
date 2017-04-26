package com.krzysztofziomek.tree;

import static com.krzysztofziomek.utils.ArrayUtils.exchange;

/**
 * @author Krzysztof Ziomek
 * @since 25/04/2017.
 */
public class BinaryMaxHeap {

    private int[] A;
    private int heapSize;

    public BinaryMaxHeap() {
    }

    public void buildMaxHeap(int[] A) {
        initialize(A);
        for (int i = heapSize / 2; i >= 0; i--) {
            maxHeapify(i);
        }
    }

    public void heapSort(int[] A) {
        buildMaxHeap(A);
        sort();
    }

    public int heapExtractMax() {
        if (heapSize < 1) {
            throw new RuntimeException();
        }
        int max = A[0];
        A[0] = A[heapSize - 1];
        removeLastElem();
        maxHeapify(0);
        return max;
    }

    public void heapIncreaseKey(int i, int key) {
        if (key < A[i]) {
            throw new IllegalStateException("New key is smaller than current key");
        }
        A[i] = key;
        while (i > 0 && A[parent(i)] < A[i]) {
            exchange(A, i, parent(i));
            i = parent(i);
        }
    }

    public void maxHeapInsert(int k) {
        heapSize++;

        int[] resizedA = new int[heapSize];
        System.arraycopy(A, 0, resizedA, 0, A.length);
        A = resizedA;

        A[heapSize - 1] = k - 1;
        heapIncreaseKey(heapSize - 1, k);
    }

    public int[] getData() {
        return A;
    }

    private void sort() {
        for (int i = heapSize - 1; i >= 1; i--) {
            exchange(A, 0, i);
            heapSize = heapSize - 1;
            maxHeapify(0);
        }
    }

    private void removeLastElem() {
        heapSize = heapSize - 1;
        int[] oldA = A;
        A = new int[heapSize];
        System.arraycopy(oldA, 0, A, 0, heapSize);
    }


    private void maxHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int largest = i;
        if (l < heapSize && A[l] > A[largest]) {
            largest = l;
        }
        if (r < heapSize && A[r] > A[largest]) {
            largest = r;
        }
        if (largest != i) {
            exchange(A, i, largest);
            maxHeapify(largest);
        }
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private void initialize(int[] inputA) {
        A = new int[inputA.length];
        System.arraycopy(inputA, 0, A, 0, inputA.length);
        this.heapSize = inputA.length;
    }
}
