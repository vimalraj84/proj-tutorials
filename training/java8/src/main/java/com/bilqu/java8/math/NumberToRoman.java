package com.bilqu.java8.math;

import java.util.Comparator;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//This is developed only for the two numbers 
public class NumberToRoman {

	public static void main(String[] args) {
//
//		IntStream.rangeClosed(1, 20).forEach(i -> {
//			System.out.format("Roman Letter for %d = %s\n",i,printRomanLetter(i));
//			System.out.format("Roman Letter for %d = %s\n",i,printRoman(i));
//		});

		System.out.format("Roman Letter for %d = %s\n",100,printRoman(8));
	}


	public static String printRomanLetter(int ip) {

		if ((ip <= 0) || (ip > 20)) {
			throw new IllegalArgumentException(ip + " input a number between (0,20)");
		}
		
		StringBuilder romanLetter = new StringBuilder();

		int tens = ip/10;

		if(tens == 1) {
			romanLetter.append(RomanIndex.getRomanLetter(10));	
		}

		int ones = ip%10;

		if(ones > 0) {
			if(ones == 4) {
				romanLetter.append(RomanIndex.getRomanLetter(1));
				romanLetter.append(RomanIndex.getRomanLetter(5));
			} else if(ones < 4) {
				//split the number by ones
				IntStream.rangeClosed(1,ones).forEach(i -> romanLetter.append(RomanIndex.getRomanLetter(1)));
			}else if(ones < 9) {
				romanLetter.append(RomanIndex.getRomanLetter(5));
				IntStream.rangeClosed(1,ones-5).forEach(i -> romanLetter.append(RomanIndex.getRomanLetter(1)));
			} else if(ones == 9) {
				romanLetter.append(RomanIndex.getRomanLetter(1));
				romanLetter.append(RomanIndex.getRomanLetter(10));
			}else {
				romanLetter.append(RomanIndex.getRomanLetter(ones));	
			}
		}
		return romanLetter.toString();
	}

	public static enum RomanIndex{

		I(1),
		IV(4),
		V(5),
		IX(9),
		X(10),
		XL(40),
		L(50),
		XC(90),
		C(100),
		CD(400),
		D(500),
		CM(900),
		M(1000);

		int value;

		private RomanIndex(int num) {
			this.value = num;
		}

		public static String getRomanLetter(int num) {
			for(RomanIndex v : RomanIndex.values()) {
				if(v.value == num) {
					return v.toString();
				}
			}
			return null;
		}
	}


	public static String printRoman(int ip) {
		List<RomanIndex> romanIndexList = EnumSet.allOf(RomanIndex.class)
				.stream()
				.sorted(Comparator.comparing((RomanIndex rl) -> rl.value).reversed()).collect(Collectors.toList());
		
		int i = 0;
		StringBuilder sb = new StringBuilder();
		
		while (ip > 0 && i < romanIndexList.size()) {
			RomanIndex currentSymbol = romanIndexList.get(i);
			if (currentSymbol.value <= ip) {
				sb.append(currentSymbol.toString());
				ip -= currentSymbol.value ;
			} else {
				i++;
			}
		}
		return sb.toString();
	}
	
	public static int pringNumber(String ip) {
		
		char[] input = ip.toCharArray();
		
		for(char r:input) {
			
			
			
		}
		
		return 0;
	}

}
