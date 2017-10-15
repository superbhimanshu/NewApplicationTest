package com.test;

public class BasicTests {

	public static void main(String[] args) {

		int[][] a = {{1,2}, {3,4}};
		int[] b = (int[]) a[1];
		Object o = a;
//		int[] b2 = (int[]) o;
		System.out.println(b[1]);
	}

}
