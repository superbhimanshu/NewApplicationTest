package com.test.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class PossiblePalindromeByString {

	public static Set<String> setStr = new HashSet<String>();
	public static void main(String[] args) {
		String s = "ivicc";
		allPermutations("", s);
		Iterator<String> it = setStr.iterator();
		while (it.hasNext()) {
	//		System.out.println(it.next() + " " + );
			String pal = it.next();
			if (isPalindrome(pal)) {
				System.out.println(pal);

			}
		}
		
			
	}
	
	private static String possiblePalindrome(String s) {
		
		boolean even;
		if(s.length()%2==0){
			even=true;
		}else {
			even = false;
		}
		char[] c = s.toCharArray();
		char[] p = new char[c.length];
		Map<Character, Integer> charCountMap = new HashMap<Character, Integer>();
		for (int i=0; i<c.length; i++){
			if(charCountMap.containsKey(c[i])){
				charCountMap.put(c[i], (charCountMap.get(c[i]))+	1);
			}else {
				charCountMap.put(c[i], 1);
			}
		}
		
		Iterator it = charCountMap.entrySet().iterator();
		int i=0, j = c.length-1;
		while(it.hasNext()){
			Map.Entry pair = (Map.Entry) it.next();
			char key = (Character) pair.getKey();
			int freq = (Integer) pair.getValue();
			if(freq%2!=0){
				p[p.length/2] = key;
				freq--;
			}
			if(freq%2==0){
				int ct = freq/2;
				while(ct!=0){
					p[i]=key;
					p[j]=key;
					i++;
					j--;
					ct--;
				}
			}
			
		}
		
		return String.valueOf(p);
	}

	public static boolean isPalindromPossible(String s){
		boolean even;
		if(s.length()%2==0){
			even=true;
		}else {
			even = false;
		}
		char[] c = s.toCharArray();
		Map<Character, Integer> charCountMap = new HashMap<Character, Integer>();
		for (int i=0; i<c.length; i++){
			if(charCountMap.containsKey(c[i])){
				charCountMap.put(c[i], (charCountMap.get(c[i]))+	1);
			}else {
				charCountMap.put(c[i], 1);
			}
		}
		Iterator it = charCountMap.entrySet().iterator();
		int countOddFreq = 0;
		boolean flag =false;
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry)it.next();
			if (even) {
				if((Integer)pair.getValue()%2 !=0){
					System.out.println("No palindrom possible");
					flag=true;
					return false;
				}
				
			}else {
				if((Integer)pair.getValue()%2 !=0){
					countOddFreq++;
				}
			}
			
		}
		if(!even && countOddFreq!=1){
			System.out.println("No palindrom possible");
			return false;
		}else if(!even && countOddFreq==1){
			System.out.println("palindrom possible");
			return true;
		}
		
		return true;
	}
	
	
	public static boolean makePal(String input){

	    HashMap<Character, Integer> map = new HashMap<>();
	    int value =1, numberOfOddOccurence = 0;
	    //find the number of occurrences
	    for(int i=0; i<input.length(); i++){
	        char key = input.charAt(i);
	        if(!map.containsKey(key)){
	            map.put(key, value);
	        }else{
	            map.put(key, map.get(key)+1);
	        }
	    }

	    //find the number of char with odd counts
	    for(Map.Entry<Character, Integer> a : map.entrySet()){
	        if(a.getValue()%2==1){
	            numberOfOddOccurence++;
	        }
	    }

	    if(numberOfOddOccurence>1)
	        return false;
	    else{
	        char [] charArray = new char[input.length()];
	        int cursor = 0;
	        for(Map.Entry<Character, Integer> a : map.entrySet()){
	            if(a.getValue()%2==0){
	                charArray[cursor] = (char)(a.getKey());
	                charArray[input.length()-cursor-1] = (char)(a.getKey());
	                cursor++;
	            }else{
	                charArray[(int) Math.ceil(input.length()/2)] = (char) (a.getKey());
	            }
	        }
	        System.out.println(String.valueOf(charArray));
	    }

	    return true;
	}

	public static void allPermutations(String prefix, String s){
		int n = s.length();
		if(n==0){
//			System.out.println(prefix);
			setStr.add(prefix);
		} else {
			for (int i = 0; i < n; i++) {
				allPermutations(prefix + String.valueOf(s.charAt(i)), s.substring(0, i) + s.substring(i + 1, n));
			}
		}
	}
	
	public static boolean isPalindrome(String s){
		char[] c = s.toCharArray();
		for(int i=0; i<c.length; i++) {
			if(c[i]!=c[c.length-i-1])
				return false;
		}
		return true;
	}
}
