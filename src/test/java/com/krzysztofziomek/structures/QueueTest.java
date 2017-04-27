package com.krzysztofziomek.structures;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Krzysztof Ziomek
 * @since 27/04/2017.
 */
public class QueueTest {

    @Test
    public void testQueue() {
        Queue queue = new Queue(5);

        assertTrue(queue.isEmpty());

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        try {
            queue.enqueue(6);
        } catch (Exception ex) {
            assertEquals("overflow", ex.getMessage());
        }

        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());

        queue.enqueue(6);
        queue.enqueue(7);

        assertEquals(4, queue.dequeue());
        assertEquals(5, queue.dequeue());
        assertEquals(6, queue.dequeue());
        assertEquals(7, queue.dequeue());

        assertTrue(queue.isEmpty());

    }

}