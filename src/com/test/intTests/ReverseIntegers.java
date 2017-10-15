package com.test.intTests;

public class ReverseIntegers {

	public static void main(String[] args) {

		int val = 123;
		int rev = 0;
		while(val!=0 ){
			rev = rev*10 + val%10;
			val = val/10;
		}
		System.out.println(rev);
	}

}
