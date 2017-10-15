package com.test.search;

public class BinarySearch {

	static int[] arr = {2,3,4,7,9,14,14,19};
	public static void main(String[] args) {
		System.out.println(binarySearch(arr,19));
	}
	
	public static int binarySearch(int[] sortedArr, int a){
		int first =0;
		int last = sortedArr.length-1;
		while(first<=last){
			int mid = (first + last)/2;
			if(a<sortedArr[mid]){
				last = mid;
			}else if(a>sortedArr[mid]){
				first = mid+1;
			}else{
				return mid;
			}
		}
		return -1;
	}

}
