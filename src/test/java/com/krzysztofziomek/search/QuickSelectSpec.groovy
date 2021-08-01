package com.krzysztofziomek.search

import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author Krzysztof Ziomek
 * @since 01/08/2021.
 */
class QuickSelectSpec extends Specification {

    @Unroll
    def "#k-th smallest in #A should be #result"() {
        expect:
        new QuickSelect().kthSmallest(A, k) == result

        where:
        A                              | k | result
        new int[]{7, 10, 4, 3, 20, 15}    | 1 | 3
        new int[]{7, 10, 4, 3, 20, 15}    | 2 | 4
        new int[]{7, 10, 4, 3, 20, 15}    | 3 | 7
        new int[]{7, 10, 4, 3, 20, 15}    | 4 | 10
        new int[]{7, 10, 4, 3, 20, 15}    | 5 | 15
        new int[]{7, 10, 4, 3, 20, 15}    | 6 | 20

        new int[]{10, 4, 5, 8, 6, 11, 26} | 3 | 6
    }
}