package com.test.BacktrackAlgorithms;

public class NQueenProblem {

	public static final int N=5;
	public static void main(String[] args) {

		int board[][] = new int[N][N];
		for(int i=0; i<N; i++){
			for(int j=0;j<N;j++){
				board[i][j]=0;
			}
		}
		
		if(solveNQueenUtil(board,0)){
			printSolution(board);
		}
	}

	public static void printSolution(int board[][]){
		for (int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				System.out.print(" " + board[i][j]);
			}
			System.out.println();
		}
	}
	
	//Utility function to check if a queen can be placed on board[row][column]
	//This method is called when "col" queens are already placed in columns
	//from 0 to col-1.
	public static boolean isSafe(int board[][], int row, int col){
		int i,j;
		//check this row on left
		for(i=0;i<col;i++){
			if(board[row][i]==1)
				return false;
		}
		//check upper diagonal on left 
		for(i=row,j=col;i>=0 && j>=0;i--,j--){
			if(board[i][j]==1){
				return false;
			}
		}
		
		//check lower diagonal on left
		for(i=row,j=col;i<N && j>=0;i++,j--){
			if(board[i][j]==1){
				return false;
			}
		}
		return true;
	}
	
	//recursive utility method to solve Nqueen
	
	public static boolean solveNQueenUtil(int board[][], int col){
		//base case if all queens are placed correctly
		if(col>=N){
			return true;
		}
		//consider current column and try placing queen in all rows
		
		for(int i=0;i<N;i++){
			if(isSafe(board,i,col)){
				board[i][col]=1;
				
				//recur to place rest of the queens
				if(solveNQueenUtil(board, col+1)){
					return true;
				}
				
				//if code comes here, it means we need to backtrack
				board[i][col]=0;
			}
		}
		
		return false;
	}
	
}
