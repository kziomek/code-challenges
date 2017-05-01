package com.krzysztofziomek.structures.set;

import com.krzysztofziomek.structures.set.ArrayBasedSet;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Krzysztof Ziomek
 * @since 01/05/2017.
 */
public class ArrayBasedSetTest {

    @Test
    public void test() throws Exception {
        ArrayBasedSet<String> set = new ArrayBasedSet<>();

        Assert.assertTrue(set.isEmpty());

        set.add(null);

        Assert.assertFalse(set.isEmpty());

        set.add("1");
        set.add("2");
        set.add("3");
        set.add("4");
        set.add("5");
        set.add("6");
        System.out.println(set.toString());

        Assert.assertEquals(7, set.size());
        Assert.assertTrue(set.contains("3"));
        Assert.assertTrue(set.contains(null));

        set.remove("3");
        Assert.assertEquals(6, set.size());
        Assert.assertFalse(set.contains("3"));
        set.remove(null);
        Assert.assertFalse(set.contains(null));

        System.out.println(set.toString());

    }

}