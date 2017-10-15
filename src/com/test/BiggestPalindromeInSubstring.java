package com.test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class BiggestPalindromeInSubstring {

	public static void main(String[] args) {

		String str = "AABCDCBA";
		String output ="";
		
		for(int i=0; i<str.length(); i++){
			for(int j=i;j<=str.length();j++) {
					if(str.substring(i, j).length() > output.length() &&isPalindrome(str.substring(i, j)) ){
						output = str.substring(i, j);
					}
			}
		}

		System.out.println(output);
	}

	private static boolean isPalindrome(String val) {
			for (int i = 0; i < (val.length() / 2); i++) {
				if (val.charAt(i) != val.charAt(val.length() - i - 1)) {
					return false;
				}
			}
		return true;
	}
	


}
