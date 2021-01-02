package com.krzysztofziomek.codility;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author Krzysztof Ziomek
 * @since 02/01/2021.
 */
@RunWith(Parameterized.class)
public class NestingTest {

    private final Nesting nesting;
    private final String input;
    private final int expectedResult;

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            {"(()(())())", 1},
            {"())", 0}
        });
    }

    public NestingTest(String input, int expectedResult) {
        this.nesting = new Nesting();
        this.input = input;
        this.expectedResult = expectedResult;
    }

    @Test
    public void testNesting() {
        Assert.assertEquals(expectedResult, nesting.solution(input));
    }
}