package com.krzysztofziomek.codility;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Krzysztof Ziomek
 * @since 27/04/2017.
 */
public class BracketsTest {

    @Test
    public void solution() throws Exception {
        Brackets brackets = new Brackets();

        Assert.assertEquals(1, brackets.solution("{[()]}"));
        Assert.assertEquals(0, brackets.solution("{[()]}{"));
        Assert.assertEquals(1, brackets.solution(""));
        Assert.assertEquals(1, brackets.solution("{}"));
        Assert.assertEquals(0, brackets.solution(")("));
    }

}