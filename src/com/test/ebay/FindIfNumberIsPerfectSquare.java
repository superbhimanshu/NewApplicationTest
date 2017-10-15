package com.test.ebay;

public class FindIfNumberIsPerfectSquare {

//	static int N = 4;
	static int M = 10;
	public static void main(String[] args) {
		boolean flag = false;
		for(int i=0;i<=M/2;i++){
			if((i*i)==M){
				flag =true;
				break;
			}
			if(i*i > M) {
				break;
			}
		}
			System.out.println(flag);
	}

}
