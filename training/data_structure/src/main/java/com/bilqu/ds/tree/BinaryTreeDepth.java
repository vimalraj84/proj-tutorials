package com.bilqu.ds.tree;

public class BinaryTreeDepth {

    public static void main (String[] a){
        BinaryTree<Integer> binaryTree = new BinaryTree(5);
        binaryTree.addNode(binaryTree.getRoot(),4);
        binaryTree.addNode(binaryTree.getRoot(),6);
        binaryTree.addNode(binaryTree.getRoot(),8);
        binaryTree.addNode(binaryTree.getRoot(),2);
        binaryTree.addNode(binaryTree.getRoot(),9);
        binaryTree.addNode(binaryTree.getRoot(),1);
        binaryTree.addNode(binaryTree.getRoot(),3);
        binaryTree.addNode(binaryTree.getRoot(),1);
        binaryTree.addNode(binaryTree.getRoot(),1);
        binaryTree.addNode(binaryTree.getRoot(),1);

        binaryTree.print();

        System.out.println(findDepth(binaryTree ));

    }

    public static int findDepth(BinaryTree<Integer> binaryTree ){

        int depth = 0;

        binaryTree.


        return depth;
    }

}
