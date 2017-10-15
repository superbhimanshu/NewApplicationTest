package com.test.ebay;

import java.util.ArrayList;

//N=10, K=3 ([1,2,3])  print all combination such that x1+x2+..+xp=N where xp<=K
public class PrintAllValueWithSummationN {

	public static int N=4;
	public static int K=2;
	public static ArrayList<ArrayList<Integer>> out = new ArrayList<ArrayList<Integer>>();
	
	public static void main(String[] args) {

		if(allCombsWithSumN(N,K, new ArrayList<Integer>(),0)){
			System.out.println();
		}
	}
	
	public static boolean allCombsWithSumN(int n, int k, ArrayList<Integer> in, int index) {
		
		if(sum(in)==n){
			out.add(in);
//			in=null;
			return true;
		}
		if(sum(in)>n){
			return false;
		}
		
		for(int j=1;j<=k;j++){
			for(int i=j+index;i<=k;i++){
				if(in==null){
					in = new ArrayList<Integer>();
				}
				in.add(i);
				if(!allCombsWithSumN(n,k,in,index+1)){
					in.remove(new Integer(i));
				}else{
					in = new ArrayList<Integer>();
				}
				
			}
		}
		return false;
	}
	
	public static int sum(ArrayList<Integer> in ){
		int sum=0;
		if(in !=null){
			for(int i : in){
				sum=sum+i;
			}
		}
		return sum;
	}

}
