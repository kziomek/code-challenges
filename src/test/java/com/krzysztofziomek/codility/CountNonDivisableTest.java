package com.krzysztofziomek.codility;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Krzysztof Ziomek
 * @since 13/05/2017.
 */
public class CountNonDivisableTest {

    @Test
    public void solution() throws Exception {

        CountNonDivisable countNonDivisable = new CountNonDivisable();
        int[] solution = countNonDivisable.solution(new int[]{3, 1, 2, 3, 6});

        Assert.assertArrayEquals(new int[]{2, 4, 3, 2, 0}, solution);

    }

}