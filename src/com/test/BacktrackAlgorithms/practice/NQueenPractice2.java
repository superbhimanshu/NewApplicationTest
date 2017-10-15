package com.test.BacktrackAlgorithms.practice;

public class NQueenPractice2 {

	public static int M = 4;

	public static void main(String[] args) {

	}

	public static boolean isSafe(int[][] N, int col, int row) {
		boolean result = true;

		for (int i = 0; i < col; i++) {
			if (N[row][i] == 1) {
				result = false;
				break;
			}
		}

		if (result) {
			for (int i = col - 1, j = row - 1; i >= 0 && j >= 0; i--, j--) {
				if (N[j][i] == 1) {
					result = false;
					break;
				}
			}
		}

		if (result) {
			for (int i = col - 1, j = row + 1; i >= 0 && j < M; i--, j++) {
				if (N[j][i] == 1) {
					result = false;
					break;
				}
			}
		}
		return result;

	}

	
	public static boolean NQueenSolveUtil(int[][] N, int col){
		
		if(col==M){
			return true;
		}
		for(int i=0;i<M;i++){
			if(isSafe(N,col,i)){
				N[i][col]=1;
			}else{
				continue;
			}
			if(NQueenSolveUtil(N,col+1)){
				return true;
			}else{
				N[i][col]=0;
			}
			
		}
		
		return false;
	}
}
