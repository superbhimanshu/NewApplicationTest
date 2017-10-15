package com.test.BacktrackAlgorithms;

public class KnightTour {

	static int N=8;
	public static void main(String[] args) {
		solveKT();
	}
	
	public static boolean isSafe(int sol[][], int x, int y){
		return (x>=0 
				&& x<N 
				&& y>=0 
				&& y<N 
				&& sol[x][y]==-1);
	}
	
	public static void printSolution(int[][] sol){
		for (int x=0; x<N;x++){
			for(int y=0;y<N;y++){
				System.out.print(sol[x][y] + " ");
			}
			System.out.println();
		}
	}

	//this method solves the problem by backtracking
	
	public static boolean solveKT(){
		int[][] sol = new int[8][8];
		
		for(int x =0 ; x<N; x++)
			for(int y=0;y<N;y++)
				sol[x][y]=-1;
		
		//xmove[] and ymove[] define next move of knight
		//xmove[] is for next value of x-coordinate
		//ymove[] is for next value of y coordinate
		int xmove[] = {2,1,-1,-2,-2,-1,1,2};
		int ymove[] = {1,2,2,1,-1,-2,-2,-1};
		//since knigh is at origin
		sol[0][0]=0;
		
		//start form 0,0 and explore all tours
		if(!solveKTUtil(0,0,1,sol,xmove,ymove)){
			System.out.println("Solution does not exist");
			return false;
		}else{
			printSolution(sol);
		}
		return true;
		
	}
	
	public static boolean solveKTUtil(int x, int y, 
			int movei, int[][] sol, int[] xmove, int[] ymove){
		int k,next_x,next_y;
		if(movei==N*N)
			return true;
		
		//try all moves from current coordinate
		for (k=0;k<N;k++){
			next_x = x + xmove[k];
			next_y = y + ymove[k];
			if(isSafe(sol,next_x,next_y)){
				sol[next_x][next_y]=movei;
				if(solveKTUtil(next_x,next_y,movei+1,sol,xmove,ymove)){
					return true;
				}else{
					sol[next_x][next_y]=-1;
				}
			}
		}
		return false;
	}
}
