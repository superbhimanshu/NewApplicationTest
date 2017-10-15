package com.test.BacktrackAlgorithms.practice;

public class NQueenPractice {

	static int N = 4;

	public static void main(String[] args) {

		int[][] chess = new int[4][4];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				chess[i][j] = 0;
			}
		}
		
		solveNQueen(chess, 0);
		printArray(chess);

	}

	public static boolean isSafe(int[][] chess, int row, int col) {

		for (int i = col-1; i >= 0; i--) {
			if (chess[row][i] == 1) {
				return false;
			}
		}
		// check if upper half is safe
		for (int i = row-1 , j = col-1 ; i >= 0 && j >= 0; i--, j--) {

			if (chess[i][j] == 1) {
				return false;
			}
		}

		// check lower half
		for (int i = row+1 , j = col-1 ; i <N && j >= 0; i++, j--) {
			if (chess[i][j] == 1) {
				return false;
			}
		}
		return true;
	}

	public static boolean solveNQueen(int[][] chess, int col) {

		if (col == N) {
			return true;
		}
		for (int k = 0; k < N; k++) {
			if (isSafe(chess, k, col)) {
				chess[k][col] = 1;
			}else{
				continue;
			}

			if (solveNQueen(chess, col + 1)) {
				return true;
			} else {
				chess[k][col] = 0;
			}
		}

		return false;

	}
	
	public static void printArray(int[][] chess) {
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				System.out.print(chess[i][j] + " ");
			}
			System.out.println();
		}
	}

}
