package com.bilqu.ds.tree;

public class Node<T> {

	private T head;
	private Node<T> left;
	private Node<T> right;
	
	public Node(T value){
		this.head = value;
		this.left = null;
		this.right = null;
	}
	
	public T getHead() {
		return head;
	}
	public void setHead(T head) {
		this.head = head;
	}
	public Node<T> getLeft() {
		return left;
	}
	public void setLeft(Node<T> left) {
		this.left = left;
	}
	public Node<T> getRight() {
		return right;
	}
	public void setRight(Node<T> right) {
		this.right = right;
	}
	
	@Override
	public String toString() {
		return "["+head + "(" + left + "," + right + ")]";
	}
}
