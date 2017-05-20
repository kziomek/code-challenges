package com.krzysztofziomek.codility.prefixsum;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Krzysztof Ziomek
 * @since 20/05/2017.
 */
public class GenomicRangeQueryTest {

    @Test
    public void solution() throws Exception {

        GenomicRangeQuery genomicRangeQuery = new GenomicRangeQuery();

        Assert.assertArrayEquals(new int[]{2}, genomicRangeQuery.solution("C", new int[]{0}, new int[]{0}));

        Assert.assertArrayEquals(new int[]{2,4,1}, genomicRangeQuery.solution("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6}));
    }

}