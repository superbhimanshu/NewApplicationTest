package com.test;

//Given a string and a non-empty substring sub, compute recursively the largest substring which starts and ends with sub and return its length.
//
//strDist("catcowcat", "cat") → 9
//strDist("catcowcat", "cow") → 3
//strDist("cccatcowcatxx", "cat") → 9
public class StringDistance {

	public static void main(String[] args) {
		String s = "catcowcatcatcow";
	//	int j = s.substring(s.length());
		System.out.println(subStrLength(s, "cat"));
	}
	
	public static int subStrLength(String str, String sub){
		
		int j = str.indexOf(sub);
		if(j==str.length()-sub.length())
			return str.length();
		if(j==-1)
			return 0;

		return j + subStrLength(str.substring(j+sub.length()), sub);

	}

}
