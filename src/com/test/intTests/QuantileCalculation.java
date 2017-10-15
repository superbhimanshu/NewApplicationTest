package com.test.intTests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class QuantileCalculation {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int Q = sc.nextInt();
		int M = sc.nextInt();
		ArrayList<Nodes> nl = new ArrayList<Nodes>();
		int arrSize =0;
		for(int i=0; i< M; i++) {
			int val = sc.nextInt();
			int count = sc.nextInt();
			arrSize = arrSize + count;
			Nodes n = new Nodes(val, count);
			nl.add(n);
			
		}
		Collections.sort(nl);
		int[] arr = new int[arrSize];
		int k=0;
		for(int i = 0; i< nl.size(); i++){
			
			int j;
			for(j=0;j<nl.get(i).count ; j++){
				arr[k+j] = nl.get(i).value;
			}
			k=k+j;
		}

		int index=0;
		int k1=1;
		index = (int) Math.ceil((arrSize*k1)/(double) Q);
		System.out.println(index);
		while(index < arrSize) {
			System.out.print(""+ arr[index-1] + " ");
			k1++;
			index = (int) Math.ceil((arrSize*k1)/(double) Q);
		}
	}

}

class Nodes implements Comparable<Nodes> {

	int value; 
	int count;
	
	public Nodes (){
		
	}
	public Nodes(int value, int count) {
		this.value = value;
		this.count = count;
		
	}
	@Override
	public int compareTo(Nodes o) {
		int  compVal = o.value;
		return this.value - compVal;
	}
	
}
