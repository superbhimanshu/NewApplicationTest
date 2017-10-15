package com.test;

import java.util.Stack;

public class BalancedParanthesis {

	public static void main(String[] args) {
		System.out.println(isBalanced("[{]"));
	}

	public static boolean isBalanced(String str) {

		Stack<Character> s = new Stack<Character>();
		char[] ch = str.toCharArray();

		for (int i = 0; i < ch.length; i++) {

			if (ch[i] == '{' || ch[i] == '(' || ch[i] == '[') {
				s.push(ch[i]);
			} else {
				if ((ch[i] == '}' || ch[i] == ')' || ch[i] == ']') && s != null && !s.isEmpty()) {
					Character sc = s.pop();
					if (ch[i] == '}' && sc != '{') {
						return false;
					}
					if (ch[i] == ']' && sc != '[') {
						return false;
					}
					if (ch[i] == ')' && sc != '(') {
						return false;
					}
				} else {
					return false;
				}
			}
		}

		return true;

	}
}
