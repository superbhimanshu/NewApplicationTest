package com.test.amzQuestions;

public class AlgoToCheckWinInTicTacToe {

	static int[][] N = {{1,0,0},{0,1,0},{0,0,1}};
	public static void main(String[] args) {

	}
	
	public boolean columnWin(int[][] N,int col){
		if(N[0][col]==N[1][col] && N[1][col]==N[2][col]){
			return true;
		}
		return false;
	}


}
