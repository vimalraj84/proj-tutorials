package com.bilqu.ds.sort;

import java.util.Arrays;
import java.util.stream.IntStream;

public class InsertionSort {

	public static void main(String[] a) {
		insertionSort7(new int[] { 3, 2, 5, 1, 4 });
		insertionSort8(new int[] { 3, 2, 5, 1, 4 });
	}

	public static void insertionSort8(int[] ip) {
		System.out.println("\n\nInsertion Sort 8\n");
		IntStream.range(0, ip.length).forEach(i ->{
			int temp = 0;
			for (int j = i; j >= 0; j--) {
				if (j > 0) {
					System.out.print(String.format("is %d < %d ", ip[j], ip[j - 1]));
					if (ip[j] < ip[j - 1]) {
						temp = ip[j];
						ip[j] = ip[j - 1];
						ip[j - 1] = temp;
						temp = 0;
						System.out.print(String.format(" ,yes so swapping %d and %d", ip[j], ip[j - 1]));
					}
					System.out.println();
					Arrays.stream(ip).forEach(a -> System.out.print(a + "\t"));
					System.out.println();
				}
			}
		});
	}

	public static void insertionSort7(int[] ip) {
		System.out.println("\n\nInsertion Sort 7\n");
		int temp = 0;
		for (int i = 1; i < ip.length; i++) {
			for (int j = i; j >= 0; j--) {
				if (j > 0) {
					System.out.print(String.format("is %d < %d ", ip[j], ip[j - 1]));
					if (ip[j] < ip[j - 1]) {
						temp = ip[j];
						ip[j] = ip[j - 1];
						ip[j - 1] = temp;
						temp = 0;
						System.out.print(String.format(" ,yes so swapping %d and %d", ip[j], ip[j - 1]));
					}
					System.out.println();
					Arrays.stream(ip).forEach(a -> System.out.print(a + "\t"));
					System.out.println();
				}
			}
		}
	}

}
