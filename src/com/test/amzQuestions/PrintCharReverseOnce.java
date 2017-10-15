package com.test.amzQuestions;

import java.util.HashMap;

//print all the characters present in the given string only once in a reverse order. Time & Space complexity should not be more than O(N). 
//e.g. 
//1)Given a string aabdceaaabbbcd 
//the output should be - dcbae 
//
//2)Sample String - aaaabbcddddccbbdaaeee 
//Output - eadbc 
//
//3)I/P - aaafffcccddaabbeeddhhhaaabbccddaaaa 
//O/P - adcbhef 
public class PrintCharReverseOnce {

	static String s= "aaafffcccddaabbeeddhhhaaabbccddaaaa";
	public static void main(String[] args) {
		HashMap<Character,Integer> mp = new HashMap<Character,Integer>();
		
		for(int i=s.length()-1;i>=0;i--){
			if(!mp.containsKey(s.charAt(i))){
				System.out.print(s.charAt(i));
				mp.put(s.charAt(i), 1);
			}
		}
	}

}
