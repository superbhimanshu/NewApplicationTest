package com.test.intTests;

//You have an array of integers, and for each index you want to find the product of every integer except the integer at that index.
public class ProductOfIntsInArray {

	public static void main(String[] args) {
		int[] in = {2,3,1,5};
	//	int[] out = bruteForce(in);
		int [] out = findForwardProduct(in);
		//find reverseProducts
		int preVal = 1;
		for(int i=in.length-1;i>=0;i--){
			out[i] = preVal*out[i];
			preVal = preVal*in[i];
		}
		System.out.println(out);
	}
	
	public static int[] bruteForce(int[] in){
		int[] out = new int [in.length];
		int temp=1;
		for(int i=0; i<in.length;i++){
			for(int j=0;j<in.length;j++){
				if(j!=i){
					temp=temp*in[j];
				}
			}
			out[i]=temp;
			temp=1;
		}
		return out;
	}
	public static int[] findForwardProduct(int[] in) {
		int preVal =1;
		int[] out = new int[in.length];
		for(int i=0;i<in.length;i++){
			out[i] = preVal;
			preVal = preVal*in[i];
		}
		return out;
	}

}
