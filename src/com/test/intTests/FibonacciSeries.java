package com.test.intTests;
//write fibonacci series upto 100
public class FibonacciSeries {

	public static void main(String[] args) {
		int i=1;
		while(i<4){
			System.out.println(fibonacci(i));
			i++;
		}
	}

	public static int fibonacci(int n){
		if(n==1|| n==2)
			return 1;
		return fibonacci(n-1) + fibonacci(n-2);
	}
}
