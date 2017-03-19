package com.krzysztofziomek.kcomplementary;

import com.sun.tools.javac.util.Pair;

import java.util.*;

/**
 * @author Krzysztof Ziomek
 * @since 19/03/2017.
 * <p>
 * Write an efficient algorithm to find K-complementary pairs in a given array of integers.
 * Given Array A, pair (i, j) is K- complementary if K = A[i] + A[j];
 *
 * Algorithm complexity is O(n)
 */
public class ComplementaryPairs {
    public Set<Pair<Integer, Integer>> process(Integer[] A, Integer k) {
        Set<Pair<Integer, Integer>> pairs = new HashSet<>();
        if (A == null) {
            return pairs;
        }

        /*
         *   1. Build differential map.
         * < k - A[i], i >
         * Loop is O(n)
         */
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            put(map, k - A[i], i);
        }

        /*
         * 2. Collect pairs
         * O(n)
         */
        for (int j = 0; j < A.length; j++) {
            if (map.containsKey(A[j])) {

                /*
                 * I've wondered if this loop spoils O(n) complexity,
                 * because in scenario where i.e. we have 10 elements in A and every element is the same,
                 * we have to go through 10 elements in external loop and 10 elements in List in HashMap.
                 *
                 * However, if A table has n elements where n belongs to set of numbers, than situation described above is impossible.
                 * In other words I believe complexity of this inner used to be counted as
                 * O(1)
                 */
                for (Integer iIndex : map.get(A[j])) {
                    pairs.add(new Pair<>(j, iIndex));
                }
            }
        }

        return pairs;
    }

    private void put(Map<Integer, List<Integer>> map, Integer key, Integer value) {
        if (map.containsKey(key)) {
            map.get(key).add(value);
        } else {
            /* This may be improved, so List is not created for one element only */
            List<Integer> list = new LinkedList<>();
            list.add(value);
            map.put(key, list);
        }
    }

}
