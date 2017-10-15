package com.test.sort.practice;

public class MergeSortPractice {

	static int[] arr = {1,5,2,5,48,9,2,6};
	public static void main(String[] args) {

		mergeSort(arr, 0, arr.length-1);
		printArr(arr,0,arr.length-1);
	}
	
	public static void mergeSort(int[] arr, int start, int end){
		int mid = (start + end)/2;
		if(start<end){
			mergeSort(arr, start, mid);
			mergeSort(arr, mid+1, end);
			merge(start, mid, end);
		}
	}
	
	public static void merge(int start, int mid, int end){
		
		int[] temp = new int[arr.length];
		int i = start;
		int j = mid+1;
		int k=start;
		while(i<=mid && j<=end){
			if(arr[i] > arr[j]){
				temp[k]= arr[j];
				j++;
				k++;
			}else {
				temp[k]= arr[i];
				i++;
				k++;
			}
		}
		
		while(i<=mid){
			temp[k] = arr[i];
			i++;
			k++;
		}
		while(j<=end){
			temp[k]=arr[j];
			j++;
			k++;
		}
		
		printArr(temp, start,end);
		for(int m=start;m<=end;m++){
		
			arr[m] = temp[m];
		}
	}
	
	public static void printArr(int[]  temp, int start, int end){
		for(int i=start;i<=end; i++){
			System.out.print(temp[i] + " ");
		}
		System.out.println();
	}

}
