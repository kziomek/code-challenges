package com.krzysztofziomek.tree;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * @author Krzysztof Ziomek
 * @since 25/04/2017.
 */
public class BinaryMaxHeapTest {

    @Test
    public void buildMaxHeap() throws Exception {
        BinaryMaxHeap heap = new BinaryMaxHeap();
        int[] A = {16, 4, 10, 14, 7, 9, 3, 2, 8, 1};

        heap.buildMaxHeap(A);

        assertEquals("[16, 14, 10, 8, 7, 9, 3, 2, 4, 1]", Arrays.toString(heap.getData()));

    }

    @Test
    public void heapSort() throws Exception {
        BinaryMaxHeap heap = new BinaryMaxHeap();
        int[] A = {16, 4, 10, 14, 7, 9, 3, 2, 8, 1};

        heap.heapSort(A);

        assertEquals("[1, 2, 3, 4, 7, 8, 9, 10, 14, 16]", Arrays.toString(heap.getData()));
    }

    @Test
    public void heapExtractMax() throws Exception {
        BinaryMaxHeap heap = new BinaryMaxHeap();
        int[] A = {16, 4, 10, 14, 7, 9, 3, 2, 8, 1};

        heap.buildMaxHeap(A);
        int max = heap.heapExtractMax();

        assertEquals(16, max);
        assertEquals("[14, 8, 10, 4, 7, 9, 3, 2, 1]", Arrays.toString(heap.getData()));
    }

    @Test
    public void heapIncreaseKey() throws Exception {
        BinaryMaxHeap heap = new BinaryMaxHeap();
        int[] A = {16, 4, 10, 14, 7, 9, 3, 2, 8, 1};

        heap.buildMaxHeap(A);
        heap.heapIncreaseKey(9, 11);
        System.out.println(Arrays.toString(heap.getData()));

        assertEquals("[16, 14, 10, 8, 11, 9, 3, 2, 4, 7]", Arrays.toString(heap.getData()));

    }

    @Test
    public void maxHeapInsert() throws Exception {
        BinaryMaxHeap heap = new BinaryMaxHeap();
        int[] A = {16, 4, 10, 14, 7, 9, 3, 2, 8, 1};

        heap.buildMaxHeap(A);
        heap.maxHeapInsert(20);
        assertEquals("[20, 16, 10, 8, 14, 9, 3, 2, 4, 1, 7]", Arrays.toString(heap.getData()));
    }

}