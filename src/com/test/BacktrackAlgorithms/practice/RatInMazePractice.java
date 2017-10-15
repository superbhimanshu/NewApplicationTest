package com.test.BacktrackAlgorithms.practice;

public class RatInMazePractice {

	static int N=4;
	static int[][] sol = new int[N][N];
	public static void main(String[] args) {
		int maze[][] = {{1, 0, 0, 0},
	            {1, 1, 0, 1},
	            {0, 1, 0, 0},
	            {1, 1, 1, 1}};
		
		solveMaze(maze,sol,0,0);
		printArray(sol);
		
	}
	
	public static boolean validMove(int[][] maze, int i, int j){
		
		return i>=0 && j>=0 && i<N && j<N && (maze[i][j]==1);
	}
	
	public static boolean solveMaze(int[][] maze, int[][] sol, int i, int j ) {
		if(i==N-1 && j == N-1){
			sol[i][j]=1;
			return true;
		}
		
		if(validMove(maze, i, j)){
			sol[i][j]=1;
			if(solveMaze(maze,sol,i+1,j)){
				return true;
			}
			if(solveMaze(maze,sol,i,j+1)){
				return true;
			}
			sol[i][j]=0;
			return false;
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
