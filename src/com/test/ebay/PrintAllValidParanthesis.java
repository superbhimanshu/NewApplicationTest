package com.test.ebay;

public class PrintAllValidParanthesis {

	public static int N=3;
	public static void main(String[] args) {
		String s="";
		printParanthesis(N,N,s);
	}
	private static void printParanthesis(int leftRemain, int rightRemain, String s) {

		if(rightRemain==0){
			System.out.println(s);
			return;
		}
		
		if(leftRemain>0){
			printParanthesis(leftRemain-1, rightRemain, s+"(");
		
			if(leftRemain < rightRemain){
				printParanthesis(leftRemain, rightRemain-1, s+")");
			}
		}else {
			printParanthesis(leftRemain, rightRemain-1, s+")");
		}
	}

	

}
