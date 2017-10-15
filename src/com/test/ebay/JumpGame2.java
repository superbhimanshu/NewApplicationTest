package com.test.ebay;


//Given an array of non-negative integers, you are initially positioned at the first index of the array. 
//Each element in the array represents your maximum jump length at that position.
//
//Your goal is to reach the last index in the minimum number of jumps.
//
//For example, given array A = [2,3,1,1,4], the minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
public class JumpGame2 {

	static int[] A ={4,2,1,1,4};
	static int[] B = {};
	public static void main(String[] args) {
		int maxIndex = A.length-1;
		int lastReach = 0;
		int reach=0;
		int step=0;
		for(int i=0;i<=reach && i<A.length;i++){
			//when last jump cannot read
			//current i, increase step by 1
			if(i>lastReach){
				step++;
				lastReach=reach;
			}
			//update maximal jump
			reach = Math.max(reach, A[i]+i);
		}
		
		if(reach<maxIndex)
			System.out.println(0);
		
		System.out.println(step);
		
	}

}
