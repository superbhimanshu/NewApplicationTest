package com.test.intTests;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class TwoSum {
	
	public static void main(String[] args) {
		
		int[] arr = {3,5,6,2,4,9,1,8,7};
		int target = 10;
		
		
		String[] a = new String[10];
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		for(int i=0;i<arr.length;i++) {
			if(map.containsKey(String.valueOf(arr[i]))) {
				System.out.println(  " " + map.get(String.valueOf(arr[i]))  + " " + (i+1) );
			}else {
				map.put(String.valueOf(target - arr[i]), (i+1));
			}
		}
		
	}
	
    static int numberOfPairs(int[] a, long k) {
        
  //  	int j = (int)k-a[0];
    	int count=0;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
       for (int i=0; i<a.length;i++) {
    	   if(map.containsKey(a[i])){
    		   count++;
    	   }else {
    		   map.put((int) (k-a[i]), (i+1));
    	   }
       }
       return count;
    }
    
    
    static String[] Braces(String[] values) {
        String[] output = new String[values.length];
        int count=0;
        for (String s : values) {
           
            Stack<Character> st = new Stack<Character>();
            for(int i=0; i<s.length();i++){
                char ch = s.charAt(i);
                if(ch=='{' || ch=='[' || ch=='('){
                    st.push(ch);
                }
                if(ch=='}' || ch==']' || ch==')'){
                    if(st.isEmpty()){
                        output[count]="NO";
                        break;
                    }
                    
                    char headChar = st.peek();
                    if((headChar=='{'&& ch=='}') || (headChar=='['&& ch==']') || (headChar=='('&& ch==')')){
                        st.pop();
                    }else{
                        output[count]="NO";
                        break;
                    }
                }
            }
            if (output[count]==null && st.isEmpty()){
                output[count]="YES";
            }
            count++;
        }
        return output;
    }

}
