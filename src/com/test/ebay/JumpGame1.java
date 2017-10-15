package com.test.ebay;

//Given an array of non-negative integers, you are initially positioned at the first index of the array. 
//Each element in the array represents your maximum jump length at that position. 
//Determine if you are able to reach the last index. For example: A = [2,3,1,1,4], return true. A = [3,2,1,0,4], return false.
public class JumpGame1 {

	static int[] A = {3,2,1,0,4};//{2,3,1,1,4};
	public static void main(String[] args) {

		int maxIndex = A.length-1;
		int index =0;
		boolean flag = false;
		while(true){
			if(index>maxIndex || A[index]==0){
				break;
			}
			index = index + A[index];
			if(index==maxIndex){
				flag=true;
				break;
			}
		}
		System.out.println(flag);
	}

}
