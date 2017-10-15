package com.test.amzQuestions.Practice;

//Write all jumbled number which is >0 && <N, where N is provided by the user. 
//A jumbled number is a number whose neighbour digit (either left or right) max differ by 1 value. 
//
//e.g.: 
//8987 is a jumbled number. 
//13 is not a jumbled number. 
//123456 is a jumbled number. 
//287 is not jumbled number.
public class JumbledNumberPractice {

	public static int N = 1000;
	public static void main(String[] args) {

		for(int i=10;i<=N;i++){
			if(isJumbled(i)){
				System.out.println(i);
			}
		}
	}
	private static boolean isJumbled(int i) {
		int j = i%10;
		i=i/10;
		while(i!=0){
			int k=i%10;
			if(Math.abs(k-j)!=1){
				return false;
			}
			j=k;
			i=i/10;
		}
		return true;
	}

}
