package com.test.intTests;

import java.util.Scanner;

public class FindLCM_HCF_Of_TwoInts {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int number1 = input.nextInt();
		int number2 = input.nextInt();

		System.out.println("The GCD-HCF of two numbers is :" + gcd(number1, number2));
		System.out.println("The LCM of two numbers is :" + lcm(number1, number2));

	}

	public static int gcd(int a, int b) {
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}

	public static int lcm(int a, int b) {
		return a * b / (gcd(a, b));
	}
}
