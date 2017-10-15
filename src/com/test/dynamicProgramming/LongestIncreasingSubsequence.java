package com.test.dynamicProgramming;

//The longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a given sequence such that all elements of the subsequence are sorted in increasing order. For example, length of LIS for { 10, 22, 9, 33, 21, 50, 41, 60, 80 } is 6 and LIS is {10, 22, 33, 50, 60, 80}.
public class LongestIncreasingSubsequence {

	static int max_ref;
	public static void main(String[] args) {
	       int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
	        int n = arr.length;
	        System.out.println("Length of lis is "
	                           + _lis(arr, n) + "\n");
	}
	   /* To make use of recursive calls, this function must return
	   two things:
	   1) Length of LIS ending with element arr[n-1]. We use
	      max_ending_here for this purpose
	   2) Overall maximum as the LIS may end with an element
	      before arr[n-1] max_ref is used this purpose.
	   The value of LIS of full array of size n is stored in
	   *max_ref which is our final result */
	public static int lis(int[] arr, int n){
		if(n==1){
			return 1;
		}
		//max_ending_here is length of LIS ending with arr[n-1]
		int res, max_ending_here =1;
		for (int i=1;i<n;i++){
			res = lis(arr,i);
			if(arr[i-1]<arr[n-1] && res + 1> max_ending_here){
				max_ending_here=res+1;
			}
		}
		
		if(max_ref<max_ending_here){
			max_ref = max_ending_here;
		}
		return max_ending_here;
	}
	
	public static int _lis(int[] arr, int n){
		max_ref=1;
		lis(arr,n);
		return max_ref;
	}
}
