package com.bilqu.ds.tree;

import java.util.LinkedList;
import java.util.Queue;

//visits all the nodes of a level before going to the next level.

//Also called level-order and visits all the levels of the tree starting from the root, and from left to right.
public class BFS<T> {

	//Use a Queue to hold the nodes from each level in order. 
	//Extract each node from the list, print its values, then add its children to the queue
	public static <T> void bfsOrder(BinaryTree<T> tree) {

		if (tree == null || tree.getRoot() == null) {
			return;
		}

		Queue<Node<T>> nodeQueue = new LinkedList<>();
		nodeQueue.add(tree.getRoot());

		while(!nodeQueue.isEmpty()) {
			Node<T> node = nodeQueue.poll();

			System.out.format(" %s ",node.getHead());

			if(node.getLeft() != null)
				nodeQueue.add(node.getLeft());

			if(node.getRight() != null)
				nodeQueue.add(node.getRight());
		}
	}

}
