package com.test.ebay.practice;

public class PrintAllValidParanthesisPractice1 {

	public static int N =3;
	public static void main(String[] args) {
		printValid(N,N,"");
	}
	
	public static void printValid(int left, int right, String s){
		if(right ==0){
			System.out.println(s);
			return;
		}
		
		if(left>0){
			printValid(left-1,right,s+"(");
			if(left<right){
				printValid(left, right-1, s+")");
			}
		}else{
			printValid(left,right-1,s+")");
		}

	
		
	}
	

}
