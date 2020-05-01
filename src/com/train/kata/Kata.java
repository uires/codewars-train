package com.train.kata;

/*
	Simple, given a string of words, return the length of the shortest word(s).
	String will never be empty and you do not need to account for different data types.
*/
/**
	@author: uíres
*/
public class Kata {
	public static int findShort(String s) {

		String[] split = s.split(" ");
		int length = 0;
		int cont = 0;
		for (String string : split) {

			if (cont == 0) {

				length = string.length();
			} else {
				if (string.length() < length)
					length = string.length();
			}
			cont++;
		}

		return length;
	}

}
