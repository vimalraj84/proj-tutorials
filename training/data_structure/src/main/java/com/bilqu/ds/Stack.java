package com.bilqu.ds;

import java.util.Arrays;

// A real-world stack allows operations at one end only 
// This feature makes it LIFO (Last-in-first-out). 
public class Stack<T> {

	private int top;
	private int cap;
	private T[] stack;
	
	
	@SuppressWarnings("unchecked")
	public Stack(int cap) {
		this.top = 0;
		this.cap = cap;
		stack =  (T[]) new Object[cap] ;
	}
	
	//Removing (accessing) an element from the stack.
	public T pop() {
		T element = peek();
		stack[--top] = null;
		return element;
	}
	
	//Pushing (storing) an element on the stack. 
	public void push(T element) throws Exception {
		if(!isFull()) {
			stack[top]  = element;
			top++;
		}else {
			throw new Exception("Stack is already full");
		}
	}
	
	//get the top data element of the stack, without removing it. 
	public T peek() {
		T element = null;
		if(!isEmpty()) {
			element = stack[top-1];
		}
		return element;
	}
	
	//check if stack is empty. 
	public boolean isEmpty() {
		if(top <=0 )
			return true;
		return false;
	}
	
	//check if stack is full. 
	public boolean isFull() {
		if(top == cap)
			return true;
		return false;
	}
	
	//Used on POP and adding more to the exisitng array.
	private void resize(int top)
    {
        T[] tmp = (T[]) new Object[top];
        System.arraycopy(stack, 0, tmp, 0, top);
        stack = tmp;
    }
	
	public void print() {
		Arrays.stream(this.stack).forEach(System.out::println);
	}
}
