package com.bilqu.ds.tree;

//Go deep as much as possible in every child before exploring the next sibling. 
public class DFS<T> {

	//left sub-tree, 
	//root node 
	//right sub-tree
	public static <T> void dfsInOrder(Node<T> node ) {
		
		if(node != null) {
			dfsInOrder(node.getLeft());
			System.out.format(" %s ",node.getHead());
			dfsInOrder(node.getRight());
		}
	}
	
	//root node
	//left subtree 
	//right subtree
	public static <T> void  dfsPreOrder(Node<T> node ) {
		if(node != null) {
			System.out.format(" %s ",node.getHead());
			dfsInOrder(node.getLeft());
			dfsInOrder(node.getRight());
		}
	}
	
	//left subtree
	//right subtree, 
	//root node at the end
	public static <T> void dfsPostOrder(Node<T> node ) {
		if(node != null) {
			dfsInOrder(node.getLeft());
			dfsInOrder(node.getRight());
			System.out.format(" %s ",node.getHead());
		}
	}
}
