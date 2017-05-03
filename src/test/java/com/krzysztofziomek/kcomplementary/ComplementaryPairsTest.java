package com.krzysztofziomek.kcomplementary;

import org.apache.commons.lang3.tuple.MutablePair;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Krzysztof Ziomek
 * @since 19/03/2017.
 */
public class ComplementaryPairsTest {

    ComplementaryPairs complementaryPairs;

    @Before
    public void setUp() {
        complementaryPairs = new ComplementaryPairs();
    }

    @Test
    public void nullArrayShouldReturnEmptyResult() {
        // prepare
        Integer[] A = null;
        Integer k = 5;

        // execute
        Set<MutablePair<Integer, Integer>> resultSet = complementaryPairs.process(A, k);

        // assert
        Assert.assertEquals(0, resultSet.size());
    }

    @Test
    public void emptyArrayShouldReturnEmptyResult() {
        // prepare
        Integer[] A = {};
        Integer k = 5;

        // execute
        Set<MutablePair<Integer, Integer>> resultSet = complementaryPairs.process(A, k);

        // assert
        Assert.assertEquals(0, resultSet.size());
    }

    /**
     * A[0] + A[0] == K
     */
    @Test
    public void oneElementArrayShouldReturnKComplementaryWhenMultipliedBy2EqualsK() {
        // prepare
        Integer[] A = {2};
        Integer k = 4;

        // execute
        Set<MutablePair<Integer, Integer>> resultSet = complementaryPairs.process(A, k);

        // assert
        assertTrue(resultSet.contains(new MutablePair<>(0, 0)));
    }

    /**
     * A[0] + A[0] != K
     */
    @Test
    public void oneElementArrayShouldReturnEmptyResultWhenValueIsNotComplementaryWithItself() {
        // prepare
        Integer[] A = {1};
        Integer k = 4;

        // execute
        Set<MutablePair<Integer, Integer>> result = complementaryPairs.process(A, k);

        // assert
        assertEquals(0, result.size());
    }

    @Test
    public void positiveNumbersArrayShouldReturnValidSetOfComplementaryPairs() {
        // prepare
        Integer[] A = {1, 2, 3, 4, 5};
        Integer k = 5;

        // execute
        Set<MutablePair<Integer, Integer>> resultSet = complementaryPairs.process(A, k);

        // assert
        assertTrue(resultSet.contains(new MutablePair<>(0, 3)));
        assertTrue(resultSet.contains(new MutablePair<>(1, 2)));
        assertTrue(resultSet.contains(new MutablePair<>(2, 1)));
        assertTrue(resultSet.contains(new MutablePair<>(3, 0)));


    }

    @Test
    public void mixOfNegativeAndPositiveNumbersShouldReturnValidSetOfComplementaryPairs() {
        // prepare
        Integer[] A = {1, 2, 4, 6, -1};
        Integer k = 5;

        // execute
        Set<MutablePair<Integer, Integer>> resultSet = complementaryPairs.process(A, k);

        // assert
        assertTrue(resultSet.contains(new MutablePair<>(0, 2)));
        assertTrue(resultSet.contains(new MutablePair<>(2, 0)));
        assertTrue(resultSet.contains(new MutablePair<>(3, 4)));
        assertTrue(resultSet.contains(new MutablePair<>(4, 3)));

    }

    @Test
    public void eachDuplicatedNumberInArrayShouldBeTestedForComplementary() {
        // prepare
        Integer[] A = {1, 2, 4, 6, -1, -1};
        Integer k = 5;

        // execute
        Set<MutablePair<Integer, Integer>> resultSet = complementaryPairs.process(A, k);

        // assert
        assertTrue(resultSet.contains(new MutablePair<>(0, 2)));
        assertTrue(resultSet.contains(new MutablePair<>(2, 0)));
        assertTrue(resultSet.contains(new MutablePair<>(3, 4)));
        assertTrue(resultSet.contains(new MutablePair<>(3, 5)));
        assertTrue(resultSet.contains(new MutablePair<>(4, 3)));
        assertTrue(resultSet.contains(new MutablePair<>(5, 3)));

    }

    @Test
    public void testWhenArrayContainElementsOfEqualValue() {
        // prepare
        Integer[] A = {1, 1, 1};
        Integer k = 2;

        // execute
        Set<MutablePair<Integer, Integer>> resultSet = complementaryPairs.process(A, k);

        System.out.println(resultSet);
        // assert
        assertTrue(resultSet.contains(new MutablePair<>(0, 0)));
        assertTrue(resultSet.contains(new MutablePair<>(0, 1)));
        assertTrue(resultSet.contains(new MutablePair<>(0, 2)));
        assertTrue(resultSet.contains(new MutablePair<>(1, 0)));
        assertTrue(resultSet.contains(new MutablePair<>(1, 1)));
        assertTrue(resultSet.contains(new MutablePair<>(1, 2)));
        assertTrue(resultSet.contains(new MutablePair<>(2, 0)));
        assertTrue(resultSet.contains(new MutablePair<>(2, 1)));
        assertTrue(resultSet.contains(new MutablePair<>(2, 2)));

    }

}