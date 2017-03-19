package com.krzysztofziomek.kcomplementary;

import com.sun.tools.javac.util.Pair;

import java.util.*;

/**
 * @author Krzysztof Ziomek
 * @since 19/03/2017.
 * <p>
 * Write an efficient algorithm to find K-complementary pairs in a given array of integers.
 * Given Array A, pair (i, j) is K- complementary if K = A[i] + A[j];
 */
public class KComplementary {
    public Set<Pair<Integer, Integer>> process(Integer[] A, Integer k) {
        Set<Pair<Integer, Integer>> pairs = new HashSet<>();
        if (A == null) {
            return pairs;
        }

        /*
         *   1. Build differential map.
         * < k - A[i], i >
         */
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            put(map, k - A[i], i);
        }

        /*
         * 2. Collect pairs
         */
        for (int j = 0; j < A.length; j++) {
            if (map.containsKey(A[j])) {
                putPairs(pairs, map.get(A[j]), j);
            }
        }

        return pairs;
    }

    private void putPairs(Set<Pair<Integer, Integer>> pairs, List<Integer> indexes, Integer j) {
        for (Integer iIndex : indexes) {
            pairs.add(new Pair<>(j, iIndex));
        }

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
