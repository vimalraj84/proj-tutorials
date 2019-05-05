package com.bilqu.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.bilqu.ds.Stack;

class StackTest {
	Stack<String> stack = null;
	@BeforeEach
	void setUp() throws Exception {
		stack = new Stack<String>(5);
		stack.push("Andria");
		stack.push("Glory");
		stack.push("Mark");
		stack.push("Erin");
		stack.push("Bella");
		
		stack.print();
	}
	
	@Test
	final void testOperations() throws Exception {
		assertEquals(stack.pop(),"Bella");
		assertEquals(stack.peek(),"Erin");
		assertEquals(stack.pop(),"Erin");
		stack.push("Jane");
		assertEquals(stack.pop(),"Jane");
		assertFalse(stack.isEmpty());
		assertFalse(stack.isFull());
		
		stack.print();
		
	}
}
