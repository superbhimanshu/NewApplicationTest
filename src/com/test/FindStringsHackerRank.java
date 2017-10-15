package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class FindStringsHackerRank {

	public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);      
	        int _cases = Integer.parseInt(in.nextLine());
	        String[] _a = new String[_cases];
	        SortedSet<String> st = new TreeSet<String>();
	        List<String> ls = new ArrayList<String>();
	        
	       for(int _a_i = 0; _a_i < _cases; _a_i++) {
	            _a[_a_i] = in.nextLine();
				int length = _a[_a_i].length();
				Set<String> tmp = new TreeSet<String>();
				for (int c = 0; c < length; c++) {
					for (int i = 1; i <= length - c; i++) {
						String sub = _a[_a_i].substring(c, c + i);
						tmp.add(sub);
					}
				}
	            
				st.addAll(tmp);
	        }
	       ls.addAll(st);
	        int _query = Integer.parseInt(in.nextLine());
	       int[] query = new int[_query];
	        for(int _a_i = 0; _a_i < _query; _a_i++) {
	            query[_a_i] = Integer.parseInt(in.nextLine());
	        }
	        
	        findStrings(ls ,query);
	    }
	
	public static void findStrings(List<String> ls , int[] query){
		for(int _a_i=0; _a_i< query.length; _a_i++){
			if (query[_a_i] > ls.size()) {
				System.out.println("INVALID");
				continue;
			} else {					
					System.out.println(ls.get(query[_a_i]-1));
			}
		}
	}
}
