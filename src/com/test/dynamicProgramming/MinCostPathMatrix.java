package com.test.dynamicProgramming;
//Given a cost matrix cost[][] and a position (m, n) in cost[][], write a function that returns cost of minimum cost path to reach (m, n)
//from (0, 0). Each cell of the matrix represents a cost to traverse through that cell. Total cost of a path to reach (m, n) is 
//sum of all the costs on that path (including both source and destination). You can only traverse down, right and
//diagonally lower cells from a given cell, i.e., from a given cell (i, j), cells (i+1, j), (i, j+1) and (i+1, j+1) can be traversed.
//You may assume that all costs are positive integers.
public class MinCostPathMatrix {

	public static void main(String[] args) {
		   int arr[][] = { {1, 2, 3},
                   {4, 8, 2},
                   {1, 5, 3} };
		   
		   System.out.println(minCostUsingDPTabulation(arr, 2,2));
	}
	public static int minCost(int[][] arr, int i, int j, int m, int n){
		int cost = arr[i][j];
		if (i == m && j == n) {
			return cost;
		}
		if (i < arr.length-1 && j < arr[i].length-1) {
			if (arr[i + 1][j + 1] < arr[i][j + 1] && arr[i + 1][j + 1] < arr[i + 1][j]) {
				cost = cost + minCost(arr, i + 1, j + 1, m, n);
			} else if (arr[i][j + 1] < arr[i + 1][j + 1] && arr[i][j + 1] < arr[i + 1][j]) {
				cost = cost + minCost(arr, i, j + 1, m, n);
			} else {
				cost = cost + minCost(arr, i + 1, j, m, n);
			}
		}

		return cost;
	}
	
	public static int minCostIncludeDestValue(int[][] arr, int m, int n){
		
		if(m<0 || n<0){
			return Integer.MAX_VALUE;
		}else if(m==0 && n==0){
			return arr[m][n];
		}else {
			return arr[m][n] + 
					Math.min(Math.min(minCostIncludeDestValue(arr, m-1,n)
							, minCostIncludeDestValue(arr,m,n-1)), minCostIncludeDestValue(arr, m-1,n-1));
		}
		
	}
	
	public static int minCostUsingDPTabulation(int[][] arr, int m, int n){
		int[][] dp = new int[m+1][n+1];
		
		dp[0][0]=arr[0][0];
		for(int k=1;k<=n;k++){
			dp[0][k]	= dp[0][k-1] + arr[0][k];
		}
		for(int k=1;k<=m;k++){
			dp[k][0] = dp[k-1][0] + arr[k][0];
		}
		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
				dp[i][j] = arr[i][j] + Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]);
			}
		}
		
		return dp[m][n];
	}

}
