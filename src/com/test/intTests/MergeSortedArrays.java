package com.test.intTests;

import java.util.Arrays;

public class MergeSortedArrays {

	public static void main(String[] args) {
		int[] a = {1,3,4,4,5,7};
		int[] b = {4,4,8,90};
		merge(a,b);
	}
	
	public static void merge(int[] a, int[] b) {
		int[] c = new int[a.length + b.length];
		
		int k=0;
		for(int i=0,j=0;i<=a.length && j<=b.length && k<a.length+b.length;) {
			if(i==a.length){
				while(j!=b.length){
					c[k]=b[j];
					k++;
					j++;
				}
				break;
			}else if(j==b.length){
				while(i!=a.length){
					c[k]=a[i];
					k++;
					i++;
				}
				break;
			}
			if(a[i]<b[j]){
				c[k]=a[i];
				k++;
				i++;
			}else if(a[i]>b[j]){
				c[k]=b[j];
				j++;
				k++;
			}else if(a[i]==b[j]){
				c[k]=a[i];
				k++;
				i++;
				c[k]=b[j];
				k++;
				j++;
				
			}
		}
		System.out.println(Arrays.toString(c));
	}

}
