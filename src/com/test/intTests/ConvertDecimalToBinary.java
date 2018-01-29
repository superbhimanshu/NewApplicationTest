package com.test.intTests;

public class ConvertDecimalToBinary {

	public static void main(String[] args) {
		
		int n= 10;
		String s = "";
		while(n!=0){
			s = String.valueOf(n%2) + s;
			n=n/2;
		}
		System.out.println(s);
	}

}
