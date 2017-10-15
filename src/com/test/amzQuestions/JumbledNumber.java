package com.test.amzQuestions;


//Write all jumbled number which is >0 && <N, where N is provided by the user. 
//A jumbled number is a number whose neighbour digit (either left or right) max differ by 1 value. 
//
//e.g.: 
//8987 is a jumbled number. 
//13 is not a jumbled number. 
//123456 is a jumbled number. 
//287 is not jumbled number.

public class JumbledNumber {

	static int N = 100;
	public static void main(String[] args) {

		for(int i=10;i<N;i++){
			if(isJumbled(i)){
				System.out.println(i);
			}
		}
	}
	
	public static boolean isJumbled(int n){
		boolean result = false;
		int i=n,j;
		int k = i%10;
		i=i/10;
		while(i!=0){
			j = i%10;
			if(Math.abs(k-j)>1){
				return result;
			}
			k=j;
			i=i/10;
		}
		
		return true;
	}

}
