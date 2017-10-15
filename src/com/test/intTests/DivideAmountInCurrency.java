package com.test.intTests;

import java.util.Arrays;

//
//Example: for amount=4 (4¢) and denominations=[1,2,3](1¢, 2¢ and 3¢), your program would output 4—the number of ways to make 44¢ with those denominations:
//
//1¢, 1¢, 1¢, 1¢
//1¢, 1¢, 2¢
//1¢, 3¢
//2¢, 2¢

public class DivideAmountInCurrency {

	public static void main(String[] args) {
		int amount = 10;
		int[] currency = { 1, 2, 3 };
		int[] maxMultiple = new int[currency.length];
		Arrays.sort(currency);
		for(int i=0;i<currency.length; i++){
			maxMultiple[i]= amount/currency[i];
		}
		
		int[] vals = new int[currency.length];
		printAll(0,currency,amount,vals);

	}

	
	 public static void printAll(int ind, int[] denom,int N,int[] vals){
		    if(N==0){
		        System.out.println(Arrays.toString(vals));
		        return;
		    }
		    if(ind == (denom.length))return;             
		    int currdenom = denom[ind];
		    for(int i=0;i<=(N/currdenom);i++){
		        vals[ind] = i;
		        printAll(ind+1,denom,N-i*currdenom,vals);
		    }
		 }

}
