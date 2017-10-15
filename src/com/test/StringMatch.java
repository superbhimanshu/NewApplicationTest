package com.test;

import java.util.Iterator;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class StringMatch {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String abc = sc.nextLine();
//        System.out.println(abc);
        for (int i =0; i<T; i++){
            String str = sc.nextLine();
 //           System.out.println(str);
            String[] data = str.split(" ");
            findMatch(data[0], data[1]);
 //           sc.nextLine();       
            
        }
    }
    
    
    public static void findMatch(String p, String v){
        
    	SortedSet s = new TreeSet();
        int i=0;
        StringBuffer sb = new StringBuffer();
        int i1 = p.length() - v.length();
        while(i<= i1){
            int j=0;
            int countErr=0;
            int countErr1=0;
            int n = v.length()-1;
            while(j<=n){
            	
				if (countErr < 2) {
					if (v.charAt(j) != p.charAt(i + j)) {
						countErr++;
					}
					if ((v.charAt(n) != p.charAt(i + n)) && n != j) {
						countErr++;
					}
				}
                
				if (countErr1 < 2) {
					if (v.charAt(j) != p.charAt(i1 + j)) {
						countErr1++;
					}
					if ((v.charAt(n) != p.charAt(i1 + n)) && n != j) {
						countErr1++;
					}
				}
				
                if(countErr>1 && countErr1 >1){
                    break;
                }

                j++;
                if(n>0)
                    n--;
            }
            if(countErr<=1){
//                sb.append(i).append(" ");
            	s.add(i);
            }
            
            if(countErr1<=1){
  //              sb.append(i1).append(" ");
            	s.add(i1);
            }
            
            i++;
            if(i1>0 && i!=i1)
                i1--;
        //    i = i + j + 1;
        }
        
        Iterator it = s.iterator();
        while(it.hasNext()) {
        	Integer element = (Integer)  it.next();
        	sb.append(element).append(" ");
        }
        
        if(sb.length() !=0)
            sb.deleteCharAt(sb.length()-1);
        else
            sb.append("No Match!");
        System.out.println(sb.toString());
    }

}
