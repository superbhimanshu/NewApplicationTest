package com.test.recursion;

import java.util.Iterator;
import java.util.Stack;

public class ReverseAStack {

	public static Stack<Integer> st = new Stack<Integer>();
	public static void main(String[] args) {

		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		st.push(5);
		

		while(!st.isEmpty()){
			System.out.println(st.pop());
		}
		
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		st.push(5);
		System.out.println("----------------");
		reverseStack(st);
		
		while(!st.isEmpty()){
			System.out.println(st.pop());
		}
	}
	private static void reverseStack(Stack<Integer> st) {
		if(st.isEmpty()){
			return;
		}
		int x = st.pop();
//		st.push(val);
		reverseStack(st);
		st.push(x);
	}

}
