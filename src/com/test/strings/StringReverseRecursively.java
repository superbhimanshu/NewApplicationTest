package com.test.strings;

public class StringReverseRecursively {

	public static void main(String[] args) {

		System.out.println(reverseString("ABCDE"));
	}
	
	public static String reverseString(String s){
		if(s==null || s.length()==0)
			return "";
		else
			return reverseString(s.substring(1,s.length())) + s.charAt(0);
	}

}
