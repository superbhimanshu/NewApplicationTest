package com.test;



//You are given two arrays of length M and N having elements in range 0-9.
//Your task is to create maximum number of length K from elements of these two arrays 
//such that relative order of elements is same in the final number as in the array, they are taken from i.e. 
//If two elements a,b are taken from array1 and and a comes before b in array1 so in the 
//final number a should come before b (Relative order kept same) . 
//Example: N=4 and M =6 
//Array1 = { 3 , 4 , 6,5} 
//Array2 ={9,1,2,5,8,3} 
//Suppose K = 5, then number will be {9,8,6,5,3} 
//You can see {9,8,3} are taken from array2 in the same order as they are in Array2. Similarly {6,5} are taken from Array1 in the same order and number 98653 is maximum possible number.

//LOGIC
//F(i, j, k) = max { 10 * Array1[i] * F(i + 1, j , k - 1), F(i + 1, j + 1, k) } if Array1[i] > Array2[j] 
//max { 10 * Array2[j] * F(i, j + 1, k - 1), F(i + 1, j + 1, k) } else 
public class ReturnMaxNumberFromTwoIntegerArraysInOrder {

	static int[] Arr1 = {3,4,6,5};
	static int[]	Arr2 = {9,1,2,5,8,3};
	public static void main(String[] args) {

	}
	
	public static int func(int i, int j, int k){
		if(i>=Arr1.length || j>=Arr2.length)
			return 0;
		if(Arr1[i]>Arr2[j])
			return  Math.max(10 * Arr1[i] * func(i + 1, j , k - 1), func(i + 1, j + 1, k));
		else
			return Math.max(10 * Arr2[j] * func(i, j + 1, k - 1), func(i + 1, j + 1, k));
	}

}
