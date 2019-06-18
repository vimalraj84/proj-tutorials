package com.bilqu.ds;

//This call explains how we calculate complexity
public class BigOExample {

    // O(1) or constant time
    public static void printFirst(int[] items) {
        System.out.println(items[0]);
    }

    // O(n)  or linear time
    public static void printAll(int[] items) {
        for (int item : items) {
            System.out.println(item);
        }
    }

    // O(n^2) quadratic time
    public static void printAllPossiblePairs(int[] items) {
        for (int firstItem : items) {
            for (int secondItem : items) {
                System.out.println(firstItem + ", " + secondItem);
            }
        }
    }






}
