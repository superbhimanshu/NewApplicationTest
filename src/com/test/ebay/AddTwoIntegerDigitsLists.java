package com.test.ebay;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


//add 2 huge numbers represented by linked list. Each linked list element represents a 4 digit number: 
//
//linked list1 : 8798 -> 8765 -> 1243 -> 9856 -> 8888 -> 0914 
//linked list 2: 8710 -> 5634 -> 1276 -> 8123 -> 1354 -> 9876 
//
//output: ................-> ............. ..-> 7980->0243 -> 0790
public class AddTwoIntegerDigitsLists {

	
	public static void main(String[] args) {
		List<Integer> l1 = new ArrayList<Integer>();
		List<Integer> l2 = new ArrayList<Integer>();
		List<Integer> out = new ArrayList<Integer>();
		Stack<Integer> output = new Stack<Integer>();

		String s = "0914";
		System.out.println(Integer.parseInt(s));
		l1.add(8798);
		l1.add(8765);
		l1.add(1243);
		l1.add(9856);
		l1.add(8888);
		l1.add(914);
		
		l2.add(8710);
		l2.add(5634);
		l2.add(1276);
		l2.add(8123);
		l2.add(1354);
		l2.add(9876);

		int carry =0;
		for(int i=Math.min(l1.size(), l2.size())-1; i>=0;i--){

			int j = l1.get(i) + l2.get(i) + carry;
			if(j>=10000){
				carry=1;
				j=j % (int) Math.pow(10, (int) Math.log10(j));
			}else{
				carry=0;
			}
			output.push(j);
		}
		
		if(l1.size()>l2.size()){
			for(int i= l1.size()-l2.size()-1;i>=0;i--){
				int j= l1.get(i) + carry;
				if(j>=10000){
					carry=1;
					j=j % (int) Math.pow(10, (int) Math.log10(j));
				}else{
					carry=0;
				}
				output.push(j);
			}
		}else if(l2.size()>l1.size()){
			for(int i= l2.size()-l1.size()-1;i>=0;i--){
				int j= l1.get(i) + carry;
				if(j>=10000){
					carry=1;
					j=j % (int) Math.pow(10, (int) Math.log10(j));
				}else{
					carry=0;
				}
				output.push(j);
			}	
		}
		
		if(carry==1){
			output.push(1);
		}
		
		while(!output.isEmpty()){
			System.out.println(output.pop());
		}
		
		
	}

}
