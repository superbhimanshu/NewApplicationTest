package com.test.sort;

public class MergeSort {
	
	static int[] arr = {100,20,10,200,15,35,15};
	public static void main(String[] args) {
		mergeSort(0,arr.length-1);
	}
	
	public static void mergeSort(int start, int end){
		int mid = (start+end)/2;
		if(start<end){
			mergeSort(start,mid);
			mergeSort(mid+1, end);
			
			merge(start,mid,end);
		}
	}
	
	public static void merge(int start, int mid, int end){
		int[] temp = new int[arr.length];
		int tempIndex = start;
		
		int startIndex = start;
		int midIndex = mid +1;
		
		while(startIndex<=mid && midIndex<=end){
			if(arr[startIndex] < arr[midIndex]){
				temp[tempIndex++] = arr[startIndex++];
			}else{
				temp[tempIndex++] = arr[midIndex++];
			}
			
		}
		//copy remaining elements
		
		while(startIndex<= mid){
			temp[tempIndex++] = arr[startIndex++];
			
		}
		
		while(midIndex<= end){
			temp[tempIndex++] = arr[midIndex++];
		}
		
		//copy temp array to actual array after sorting
		for(int i= start;i<=end;i++){
			arr[i]=temp[i];
		}
		
		System.out.print("After merging  ");
		printArray(temp, start,end);
	}

	public static void printArray(int[] temp, int start, int end){
		for(int i=start;i<=end;i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
