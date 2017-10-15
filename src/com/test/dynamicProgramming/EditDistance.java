package com.test.dynamicProgramming;

public class EditDistance {

	public static void main(String[] args) {
        String str1 = "sunday";
        String str2 = "saturday";
  
        System.out.println( editDistDP( str1 , str2 ) );
	}

	public static int min(int x,int y, int z){
		return Math.min(Math.min(x,y), z);
	}
	
	public static int editDist(String a, String b){
		int m= a.length();
		int n= b.length();
		if(m==0){
			return n;
		}
		if(n==0){
			return m;
		}
		
		if(a.charAt(m-1) == b.charAt(n-1)){
			return editDist(a.substring(0, m-1), b.substring(0,n-1) );
		}
		
		return 1 + Math.min(
								//insert									remove
				Math.min(editDist(a, b.substring(0, n-1)), editDist(a.substring(0,m-1), b))
					//replace
				, editDist(a.substring(0,m-1), b.substring(0, n-1)));
	}
	
	public static int editDistDP (String a, String b){
		int m=a.length();
		int n= b.length();
		int[][] d = new int[m+1][n+1];
		for(int i=0;i<=m;i++){
			for(int j=0;j<=n;j++){
				if(i==0){
					d[i][j]=j;
				}else if(j==0){
					d[i][j]=i;
				}else if(a.charAt(i-1)==b.charAt(j-1)){
					d[i][j] = d[i-1][j-1];
				}else{
					d[i][j] = 1 + Math.min(
							Math.min(d[i][j-1], d[i-1][j])
							, d[i-1][j-1]);
				}
			}
		}
		return d[m][n];
	}
}
