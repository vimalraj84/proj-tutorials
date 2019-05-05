package com.bilqu.test;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.bilqu.ds.tree.BFS;
import com.bilqu.ds.tree.BinaryTree;
import com.bilqu.ds.tree.DFS;
import com.bilqu.ds.tree.Node;

class BinaryTreeTest {

	public static BinaryTree<Integer> binaryTree = null;
	
	@BeforeEach
	void setUp() throws Exception {
//		binaryTree.getRoot().setLeft(new Node<Integer>(2));
//		
//		Node<Integer> rNode = new Node<Integer>(3);
//		rNode.setLeft(new Node<Integer>(4));
//		rNode.setRight(new Node<Integer>(5));
//		binaryTree.getRoot().setRight(rNode);
		binaryTree = new BinaryTree(5);
		binaryTree.addNode(binaryTree.getRoot(),4);
		binaryTree.addNode(binaryTree.getRoot(),6);
		binaryTree.addNode(binaryTree.getRoot(),8);
		binaryTree.addNode(binaryTree.getRoot(),2);
		binaryTree.addNode(binaryTree.getRoot(),9);
		binaryTree.addNode(binaryTree.getRoot(),1);
		binaryTree.addNode(binaryTree.getRoot(),3);
	}

	@Test
	final void testBinaryTree() {
		binaryTree.print();
	}
	
	@Test
	final void testdfsInOrder() {
		System.out.println("\nDFS IN ORDER :\t");
		DFS.dfsInOrder(binaryTree.getRoot());
	}
	
	@Test
	final void testdfsPreOrder() {
		System.out.println("\nDFS PRE ORDER :\t");
		DFS.dfsPreOrder(binaryTree.getRoot());
	}
	
	@Test
	final void testdfsPostOrder() {
		System.out.println("\nDFS POST ORDER :\t");
		DFS.dfsPostOrder(binaryTree.getRoot());
	}
	
	@Test
	final void testbfsOrder() {
		System.out.println("\nBFS ORDER :\t");
		BFS.bfsOrder(binaryTree);
	}

}
