package com.bilqu.java8.cons;

public interface InterfaceInnerClass {
	
	void print();
	
	class One{
		public void print() {
			System.out.println("One");
		}
	}
	
	static class Two{
		public void print() {
			System.out.println("Two");
		}
	}
}
