package com.test.strings.practice;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//s = "abc"
//print a,b,c,d,e,ab,ac,bc,abc
public class AllPossibleSubstringsSet {

	public static Set<String> set = new HashSet<String>();
	
	public static String s = "abc";
	public static void main(String[] args) {
		printAllCombos(s);
	}

	public static void printAllCombos(String s){
		printAllCombos("",s);
		
//		System.out.println("-----------------------");
//		Iterator it = set.iterator();
//		while(it.hasNext()){
//			System.out.println(it.next());
//		}
	}

	private static void printAllCombos(String prefix, String s) {
		if(s==null || s.equals("")){
			System.out.println(prefix);
			set.add(prefix);
			return;
		}else{
			if(!prefix.equals(""))
				System.out.println(prefix);
				set.add(prefix);
			for(int i=0;i<s.length();i++){
				System.out.println(s.charAt(i));
				set.add(Character.toString(s.charAt(i)));
				printAllCombos(prefix + s.charAt(i),  s.substring(0, i) + s.substring(i+1, s.length()));
			}
			
		}
			
	}
}
