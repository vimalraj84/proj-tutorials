package com.bilqu.ds.tree;

//A binary tree is a recursive data structure where each node can have 2 children at most.
public class BinaryTree<T> {
	
	//Binary Search Tree
	//Parent node greater than or equal to the Left node 
	//Parent Node less than or equal to the right node.
	
	private Node<T> root;
	
	public BinaryTree(T initNode){
		this.root = new Node<T>(initNode);
	}
	

    // if the new node's value is lower than the current node's, we go to the left child
    // if the new node's value is greater than the current node's, we go to the right child
    // when the current node is null, we’ve reached a leaf node and we can insert the new node in that position

	public Node<T> addNode(Node<T> cNode, T value) {
		
		if(cNode == null)
			return new Node<T>(value) ;
		
		if(isRightNode(cNode.getHead(), value)) {
			cNode.setRight(addNode(cNode.getRight(),value));
		}else {
			cNode.setLeft(addNode(cNode.getLeft(),value));
		}
		return cNode;
	}
	
	private boolean isRightNode(T cValue, T nValue) {
		if(cValue.getClass() == Integer.class && nValue.getClass() == Integer.class  ) {
			if((Integer)cValue <= (Integer)nValue)
				return true;
		}
		
		if(cValue.getClass() == String.class && nValue.getClass() == String.class  ) {
			if((((String)cValue).compareToIgnoreCase((String)nValue)) <= 0)
				return true;
		}
		return false;
	}
	
	public Node<T> getRoot(){
		return root;
	}
	
	
	public void print() {
		TreePrinter.printNode(root);
	}
}
