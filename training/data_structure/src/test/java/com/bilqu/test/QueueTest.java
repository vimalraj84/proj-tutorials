package com.bilqu.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.bilqu.ds.Queue;

class QueueTest {
	Queue<String> queue = null;
	@BeforeEach
	void setUp() throws Exception {
		queue = new Queue<String>(5);
		queue.enqueue("Andria");
		queue.enqueue("Glory");
		queue.enqueue("Mark");
		queue.enqueue("Erin");
		queue.enqueue("Bella");
		queue.print();
	}
	
	@Test
	final void testOperations() throws Exception {
		assertEquals(queue.dequeue(),"Andria");
		assertEquals(queue.peek(),"Glory");
		assertEquals(queue.dequeue(),"Glory");
		assertThrows(Exception.class,() -> queue.enqueue("Jane"));
		assertEquals(queue.dequeue(),"Mark");
		assertFalse(queue.isEmpty());
		assertTrue(queue.isFull());
		queue.print();
	}
}
