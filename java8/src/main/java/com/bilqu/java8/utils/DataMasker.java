package com.bilqu.java8.utils;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class DataMasker {

	public static final String CONSONANT = "bcdfghjklmnpqrstvwxz";
	public static final String VOWEL = "aeiouy";
	public static final String DIGIT = "0123456789";

	public static char getRandomChar(SecureRandom r, String cs, boolean uppercase) {
		char c = cs.charAt(r.nextInt(cs.length()));
		return uppercase ? Character.toUpperCase(c) : c;
	}

	public static String mask(String input) {
		SecureRandom r = null;
		char output[] = input.toCharArray();
		try {
			r = SecureRandom.getInstanceStrong();
			for (int i = 0; i < output.length; ++i) {
				char ln = Character.toLowerCase(output[i]);
				if (CONSONANT.indexOf(ln) >= 0)
					output[i] = getRandomChar(r, CONSONANT, ln != output[i]);
				else if (VOWEL.indexOf(ln) >= 0)
					output[i] = getRandomChar(r, VOWEL, ln != output[i]);
				else if (DIGIT.indexOf(ln) >= 0)
					output[i] = getRandomChar(r, DIGIT, ln != output[i]);
			}
		} catch (NoSuchAlgorithmException e) {
			System.err.println(e.getMessage());
		}
		return new String(output);
	}
}
