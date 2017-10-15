package com.test;

public class StringRegex {
	
	public static String  abc = "asds Af 9 sd_ 023 .$\n";

	public static void main(String[] args) {
    	int maxLength = 0;
    	String validString = null;
    	if(abc != null) {
    		validString = abc.replaceAll("[^A-Za-z0-9]","");
    		maxLength = (validString.length() < 25)?validString.length():25;
    		validString = validString.substring(0, maxLength);
    	}
        System.out.println(validString);
	}

}
