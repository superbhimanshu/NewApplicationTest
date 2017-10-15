package com.test;

import java.util.HashSet;
import java.util.Set;

public class StringSubstringSet {

	public static void main(String[] args) {

		String str = "aba";
		Set<String> s = new HashSet<String>();
		
		for(int i=0; i<str.length(); i++){
	//		s.add(String.valueOf(str.charAt(i)));
			for(int j=i+1;j<=str.length();j++) {
					s.add(str.substring(i, j));
			}
		}
//		s.add(str);
	//	s.remove("");
		System.out.println(s.toString() + " size " + s.size());
		
	}
	


}
