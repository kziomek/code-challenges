package com.krzysztofziomek.codility;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author Krzysztof Ziomek
 * @since 26/04/2017.
 */
public class CyclicRotationTest {

    private CyclicRotation cyclicRotation;

    @Before
    public void setUp() {
        cyclicRotation = new CyclicRotation();
    }

    @Test
    public void testRotateBy2() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] expected = {7, 8, 1, 2, 3, 4, 5, 6};
        cyclicRotation.rotate(arr, 2);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testRotateBy3() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] expected = {6, 7, 8, 1, 2, 3, 4, 5};
        cyclicRotation.rotate(arr, 3);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testRotateByLength() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] expected = arr.clone();
        cyclicRotation.rotate(arr, arr.length);
        assertArrayEquals(expected, arr);
        cyclicRotation.rotate(arr, arr.length * 3);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testRotateByZero() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] expected = arr.clone();
        cyclicRotation.rotate(arr, 0);
        assertArrayEquals(expected, arr);
    }

}