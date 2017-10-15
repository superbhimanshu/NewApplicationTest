package com.test.dynamicProgramming;

/*Examples:
LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.*/
public class LongestCommonSubsequence {

	static String answer ="";
	public static void main(String[] args) {
		System.out.println(lcs("ABCDGH","AEDFHR"));
		System.out.println(answer);
		lcsWithTabulation("ABCDGH","AEDFHR");
	}

	public static int lcs(String a, String b) {
		
		int m=a.length();
		int n= b.length();
		if(m==0 || n==0){
			return 0;
		}
		
		if(a.charAt(m-1) == b.charAt(n-1)){
			answer = a.charAt(m-1)+answer;
			return 1 + lcs(a.substring(0, m-1), b.substring(0,n-1));
		}else {
			return Math.max(lcs(a.substring(0, m-1), b.substring(0,n)), lcs(a.substring(0,m), b.substring(0,n-1) ));
		}
	}
	
	public static void lcsWithTabulation(String a, String b){
		int m = a.length();
		int n = b.length();
		int[][] L= new int[m+1][n+1];
//		int i,j;
		
		for(int i=0;i<=m;i++){
			for(int j=0;j<=n;j++){
				if(i==0 || j==0){
					L[i][j]=0;
				}else if(a.charAt(i-1) == b.charAt(j-1)){
					L[i][j]=1+L[i-1][j-1];
				}else {
					L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
				}
				
			}
		}
		
		int index = L[m][n];
		char[] result = new char[index];
		int i=m,j=n;
		while(i>0 && j>0){
			if(a.charAt(i-1)==b.charAt(j-1)){
				result[index-1]=a.charAt(i-1);
				i--;
				j--;
				index--;
			}else if(L[i-1][j]>L[i][j-1]){
				i--;
			}else{
				j--;
			}
			
		}
		
		System.out.println(result);
	}
}
