package com.bilqu.ds;

import java.util.Arrays;

//Queue is opposite of stack 
//Queue opens at both ends.  
//it follows FIFO ( First-in-First-Out) Last in Last Out. 
public class Queue<T> {
	
	private int cap;
	private int tail;
	private int head;
	private T[] queue;
	
	@SuppressWarnings("unchecked")
	public Queue(int cap) {
		this.cap = cap;
		this.queue = (T[]) new String[cap];
		this.tail = 0;
		this.head = 0;
	}
	
	//add (store) an item to the queue.
	public void enqueue(T element)throws Exception {
		if(!isFull()){
			queue[tail] = element;
			tail++;
		}else {
			throw new Exception("Queue is full");
		}
	}

	//remove (access) an item from the queue.
	public T dequeue() {
		T element = peek();
		queue[head++] = null;
		return element;
	}

	//Gets the element at the front of the queue without removing it. 
	public T peek() {
		T element = null;
		if(!isEmpty()) {
			element = queue[head];
		}
		return element;
	}

	//Checks if the queue is full. 
	public boolean isFull() {
		if(tail == cap)
			return true;
		return false;
	}

	//Checks if the queue is empty.
	public boolean isEmpty() {
		if(tail == 0)
			return true;
		return false;
	}
	
	public void print() {
		Arrays.stream(queue).forEach(System.out::println);
	}
}
