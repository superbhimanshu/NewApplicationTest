package com.test.dynamicProgramming;

public class EggDrop {

	public static void main(String[] args) {
        int n = 2, k = 10;
        System.out.println("Minimum number of trials in worst case with "+n+"  eggs and "+k+
                 " floors is "+eggDrop(n, k));   
		
	}
	
	public static int eggDrop(int n, int k){
	       /* A 2D table where entery eggFloor[i][j] will represent minimum
	       number of trials needed for i eggs and j floors. */
		int eggFloor[][] = new int[n+1][k+1];
		int res;
		int i,j,x;
		
		for(i=1;i<=n;i++){
			eggFloor[i][1] = 1;
			eggFloor[i][0] =0;
		}
		//we always need j trials for one egg and j floors
		for(j=1;j<=k;j++){
			eggFloor[1][j]=j;
		}
		
		//fill rest of the entries in table using optimal substructue
		for (i=2;i<=n;i++){
			for(j=2;j<=k;j++){
				eggFloor[i][j] = Integer.MAX_VALUE;
				for(x=1;x<=j;x++){
					res = 1+Math.max(eggFloor[i-1][x-1],eggFloor[i][j-x]);
					if(res < eggFloor[i][j]){
						eggFloor[i][j]=res;
					}
				}
			}
		}
		
		return eggFloor[n][k];
	}

}
