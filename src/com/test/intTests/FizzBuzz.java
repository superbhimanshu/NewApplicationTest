package com.test.intTests;

public class FizzBuzz {

	public static void main(String[] args) {

		int i=1;
		while(i<=50) {
			if(i%5==0 && i%3==0){
				System.out.println("fizzbuzz");
			}else if(i%5==0 && !(i%3==0)){
				System.out.println("buzz");

			}else if(i%3==0 && !(i%5==0)){
				System.out.println("fizz");
			}else {
				System.out.println(i);
			}
			i++;
		}
	}

}
