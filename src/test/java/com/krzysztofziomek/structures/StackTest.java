package com.krzysztofziomek.structures;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Krzysztof Ziomek
 * @since 27/04/2017.
 */
public class StackTest {

    @Test
    public void testStack() throws Exception {
        Stack stack = new Stack(5);
        assertTrue(stack.empty());

        stack.push(1);
        stack.push(3);
        stack.push(5);
        stack.push(7);
        stack.push(9);

        try{
            stack.push(8);
        } catch (IllegalStateException e){
            assertEquals("overflow", e.getMessage());
        }

        assertEquals(9,stack.pop());
        assertEquals(7,stack.pop());
        assertEquals(5,stack.pop());
        assertEquals(3,stack.pop());
        assertEquals(1,stack.pop());

        assertTrue(stack.empty());

    }

}