package com.bilqu.java8.math;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class PrintAmount {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String ip = scan.nextLine();
		System.out.println("Input : "+ip);
		String[] amount = String.valueOf(ip).split("\\D");

		withEnum(amount);
		System.out.println("\n825");
		withArray(amount);
		//		withArray((n / 1000000000), " Hundred");
		//		withArray((n / 10000000) % 100, " crore");
		//		withArray(((n / 100000) % 100), " lakh");
		//		withArray(((n / 1000) % 100), " thousand");
		//		withArray(((n / 100) % 10), " hundred");
		//		withArray((n % 100), " ");


	}


	private static void withEnum(String[] amount) {
		int dollor = Integer.parseInt(amount[0]);

		System.out.format("%s Hundred ",Ones.getOnes(dollor/100));

		if(dollor%100  < 20)
			System.out.format(" %s", Ones.getOnes(dollor%100)); 
		else {
			System.out.format(" %s ",Tens.getTens((dollor/10)%10)); 
			System.out.format(" %s ",Ones.getOnes(dollor%10));
		}


		int change = Integer.parseInt(amount[1]);
		IntStream.rangeClosed(1, amount[1].length()).forEach(digit -> {

			if(digit == 1)
				System.out.format(" %s",Tens.getTens(change/10));
			else if(digit == 2)
				System.out.format(" %s cents",Ones.getOnes(change%10));
		});
	}





	private static void withArray(String[] amount)
	{
		String ones[] = { " ", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine", " Ten",
				" Eleven", " Twelve", " Thirteen", " Fourteen", "Fifteen", " Sixteen", " Seventeen", " Eighteen",
		" Nineteen" };

		String tens[] = { " ", " ", " Twenty", " Thirty", " Forty", " Fifty", " Sixty", "Seventy", " Eighty", " Ninety" };

		int dollor = Integer.parseInt(amount[0]);
		System.out.format("%s Hundred and",ones[(dollor/100)]);
		if(dollor%100 < 20)
			System.out.format(" %s",ones[dollor%100]); 
		else {
			System.out.format(" %s ",tens[(dollor/10)%10]);
			System.out.format(" %s ",ones[(dollor%10)]);
		}


		int change = Integer.parseInt(amount[1]);
		IntStream.rangeClosed(1, amount[1].length()).forEach(digit -> {

			if(digit == 1)
				System.out.format(" %s",tens[(change/10)]);
			else if(digit == 2)
				System.out.format(" %s cents",ones[(change%10)]);
		});
	}


	public static enum Ones{

		One(1),
		Two(2),
		Three(3),
		Four(4),
		Five(5),
		Six(6),
		Seven(7),
		Eight(8),
		Nine(9),
		Ten(10),
		Eleven(11), 
		Twelve(12), 
		Thirteen(13), 
		Fourteen(14), 
		Fifteen(15), 
		Sixteen(16), 
		Seventeen(17), 
		Eighteen(18),
		Nineteen(19);


		int num;

		private Ones(int n) {
			this.num=n;
		}

		public static String getOnes(int n) {
			for(Ones ones:Ones.values()) {
				if(ones.num == n)
					return ones.toString();
			}
			return "";
		}

	}

	public static enum Tens{

		Twenty(2),
		Thirty(3),
		Fourty(4),
		Fifty(5),
		Sixty(6),
		Seventy(7),
		Eighty(8),
		Ninty(9);

		int num;

		private Tens(int n) {
			this.num=n;
		}

		public static String getTens(int n) {
			for(Tens tens:Tens.values()) {
				if(tens.num == n)
					return tens.toString();
			}
			return "";
		}
	}

}
