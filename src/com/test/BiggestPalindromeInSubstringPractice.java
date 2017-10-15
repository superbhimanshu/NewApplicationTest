package com.test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by hverma on 6/6/17.
 */
public class BiggestPalindromeInSubstringPractice {

    public static void main(String[] args) {

        String str = "AABCDCBA";
        Set<String> s = new HashSet<>();
        for(int i=0;i<str.length();i++){
            s.add(String.valueOf(str.charAt(i)));
            for(int j=i+1;j<str.length();j++){
                s.add(str.substring(i,j));
            }
        }

        System.out.println(s.toString());

        Iterator<String> it = s.iterator();
        String out="";
        while(it.hasNext()){
            String possibleOut = it.next();
            if(isPalindrome(possibleOut) && possibleOut.length()>out.length()){
                out = possibleOut;
            }
        }

        System.out.println(out);
    }

    public static boolean isPalindrome(String str){
        for(int i=0,j=str.length()-1;i<j;i++,j--){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
        }
        return true;
    }

}
