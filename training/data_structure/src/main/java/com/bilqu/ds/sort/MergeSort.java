package com.bilqu.ds.sort;

import java.util.Arrays;

public class MergeSort {

	public static void main (String[] a) {

		int[] ip = {8 ,2 , 6, 4 , 7 , 5,  3,  1 };
		int[] ip2 = {27, 10, 12, 25, 34, 16, 15, 31}; 
		mergeSort7(ip);
		mergeSort7(ip2);
	}

	public static void mergeSort7(int[] ip) {
		if(ip == null)
			return;

		if(ip.length <2)
			return;

		int[] left = null;
		int[] right = null;
		
		int length = ip.length;
		int median = ip.length/2;
		
		//left = Arrays.copyOfRange(ip,0,splitter);
		left = copyArray(ip,0,median);
		Arrays.stream(left).forEach(p -> System.out.print(p+" "));
		System.out.println();
		mergeSort7(left);
		
		//right = Arrays.copyOfRange(ip,splitter,ip.length);
		right = copyArray(ip,median,length);
		Arrays.stream(right).forEach(p -> System.out.print(p+" "));
		System.out.println();
		mergeSort7(right);
		
		doMerge(ip,left,right,median,length - median);	
		Arrays.stream(ip).forEach(p -> System.out.print(p+" "));
		System.out.println();
	}

	private static void doMerge(int[] ip, int[] left,int[] right, int median, int length) {
		int index =0;
		int lindx =0;
		int rindx =0;
		
		// iterate both arrays and in each iteration add smaller of both elements
		while ( lindx < median && rindx < length) {
			if(left[lindx] > right[rindx]) {
				ip[index++] = right[rindx++];
			}else {
				ip[index++] = left[lindx++];
			}
		}
		
		while (lindx < median) {
			ip[index++] = left[lindx++];
	    }
	    while (rindx <  length) {
	    	ip[index++] = right[rindx++];
	    }
		
	}

	private static int[] copyArray(int[] ip, int start, int end) {
		//Find the length 
		int lenght = end - start;
		if(lenght < 0)
			throw new IllegalArgumentException("Invalid array lenght");

		int out[] =new int[lenght];

		for(int i =0 ;i<end && start < end;i++) {
			out[i] = ip[start++];
		}
		return out;

	}

	//	Step 1 − if it is only one element in the list it is already sorted, return. 
	//	Step 2 − divide the list recursively into two halves until it can no more be divided. 
	//	Step 3 − merge the smaller lists into new list in sorted order. 
	//
	//			Consider the following array of numbers  
	//			27  10  12  25  34  16  15  31 
	//
	//			divide it into two parts  
	//			27  10  12  25 -  34  16  15  31 
	//
	//			divide each part into two parts  
	//			27  10 -  12  25 - 34  16 -  15  31 
	//
	//			divide each part into two parts  
	//			27 -  10  -  12  -  25  -  34  -  16  -  15 -  31 
	//
	//			merge (cleverly-!) parts  
	//			10  27   -  12  25   -   16  34   -   15  31 
	//
	//			merge parts  
	//			10  12  25  27 - 15  16  31  34 
	//
	//			merge parts into one  
	//			10  12  15  16  25  27  31  34 

}


