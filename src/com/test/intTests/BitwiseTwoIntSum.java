package com.test.intTests;

public class BitwiseTwoIntSum {

	public static void main(String[] args) {
		int result = getSum(5,6);
		System.out.println(result);
	}

	public static int getSum(int p, int q)
	{
		int result = (p^q) ^ ((p&q)<<1);
//	    int result = p ^ q; // + without carry 0+0=0, 0+1=1+0=1, 1+1=0
//	    int carry = (p & q) << 1; // 1+1=2
//	    if (carry != 0) {
//	        return getSum(result, carry);
//	    }
	    return result;
	}
}
