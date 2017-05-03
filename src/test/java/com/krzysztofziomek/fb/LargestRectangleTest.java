package com.krzysztofziomek.fb;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Krzysztof Ziomek
 * @since 03/05/2017.
 */
public class LargestRectangleTest {

    @Test
    public void calculate() throws Exception {
        Assert.assertEquals(5, new LargestRectangle().calculate(new int[]{1, 3, 2, 1, 2}));
        Assert.assertEquals(6, new LargestRectangle().calculate(new int[]{1, 2, 3, 2, 1}));
        Assert.assertEquals(3, new LargestRectangle().calculate(new int[]{1, 1, 3}));
        Assert.assertEquals(6, new LargestRectangle().calculate(new int[]{1, 3, 3}));
        Assert.assertEquals(3, new LargestRectangle().calculate(new int[]{1, 0, 3}));
        Assert.assertEquals(8, new LargestRectangle().calculate(new int[]{1, 3, 3, 2, 2, 1}));
    }

}