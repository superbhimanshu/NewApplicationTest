package com.test;

import java.util.Scanner;

public class SortedArrayToString {

	public static void main(String[] args) {
		System.out.println("enter elements of sorted array in 1,2,3 format");
		Scanner sc = new Scanner(System.in);
		StringBuffer sb= new StringBuffer();
		String[] s = sc.next().split(",");	
		Integer[] a = new Integer[s.length];
		int temp=-1;
		sb.append("[");
		sb.append(s[0]);
//		sb.append("-");
		for (int i=0; i<s.length; i++){
			try{
				a[i] = Integer.parseInt(s[i]);
				if(i>0 && (a[i] < a[i-1])){
					System.out.println("Unsorted Array Elements");
					System.exit(1);
				}
				if(i>0){
					if(a[i]== a[i-1] +1){
						temp = a[i];
					}else if(a[i]!= a[i-1] +1 && temp!=-1) {
						sb.append("-").append(temp).append(",").append(a[i]);
						temp=-1;						
					}else if(a[i]!= a[i-1] +1 && temp==-1) {
						sb.append(",").append(a[i]);
					}
				}
			}catch(Exception e){
				System.out.println("Invalid Array Elements");
			}
		}
		if(temp!=-1){
			sb.append("-").append(temp).append("]");
		}else{
			sb.append("]");
		}
		System.out.println(sb.toString());
		
		
		
		
	}
}
