package com.krzysztofziomek.fb;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Krzysztof Ziomek
 * @since 09/05/2017.
 */
public class ClosestYearTest {

    @Test
    public void getClosestYear() throws Exception {
        Assert.assertEquals(1999, new ClosestYear().getClosestYear(99));
        Assert.assertEquals(2067, new ClosestYear().getClosestYear(67));
        Assert.assertEquals(2015, new ClosestYear().getClosestYear(15));
        Assert.assertEquals(2044, new ClosestYear().getClosestYear(44));
    }

}