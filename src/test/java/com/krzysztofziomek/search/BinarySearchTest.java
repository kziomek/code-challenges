package com.krzysztofziomek.search;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Krzysztof Ziomek
 * @since 27/04/2017.
 */
public class BinarySearchTest {


    @Test
    public void searchShouldntFind3InGivenList() throws Exception {
        BinarySearch binarySearch = new BinarySearch();
        int[] A = {17, 20, 26, 31, 44, 54, 55, 65, 77, 93};

        Assert.assertEquals(false, binarySearch.search(A, 3));

    }

    @Test
    public void searchShouldFind20InGivenList() throws Exception {
        BinarySearch binarySearch = new BinarySearch();
        int[] A = {17, 20, 26, 31, 44, 54, 55, 65, 77, 93};

        Assert.assertEquals(true, binarySearch.search(A, 20));

    }

}