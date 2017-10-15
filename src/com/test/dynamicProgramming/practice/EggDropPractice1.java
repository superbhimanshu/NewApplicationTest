package com.test.dynamicProgramming.practice;

public class EggDropPractice1 {

	public static int N =2;
	public static int M = 10;
	public static void main(String[] args) {

	}
	
	public static int eggDrop(int N, int M){
		
		int[][] L = new int[N+1][M+1];
		
		for(int i=0;i<=N;i++){
			L[i][0]=0;
			L[i][1]=i;
		}
		for(int j=0;j<=N;j++){
			L[j][0]=0;
		}
		
		for(int i=2;i<=N;i++){
		//	for(int j=2;)
		}
		
		
		return M;
		
		
		
	}

}
