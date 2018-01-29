package com.geeksforgeeks.recursion;

import java.util.InputMismatchException;

/**
 * Created by hverma on 11/5/17.
 * http://practice.geeksforgeeks.org/problems/sum-string/0
 */
public class SumString {

    public static void main(String[] args){

        String s = "12243660";

        for(int i=2; i<s.length();i++){
            if(isSumString(s.substring(0,i), s.substring(i,s.length()))){
                System.out.print("true");
                break;
            }
        }
    }

    public static boolean isSumString(String prefix, String suffix){
        boolean result = false;
        if(prefix.length() == 0){
            return false;
        }
        for(int i=1;i<prefix.length();i++){
            for(int j=i;j<prefix.length()-suffix.length()+1; j++) {
                String x = prefix.substring(0, i);
                String y = prefix.substring(i, prefix.length());
                if (Integer.parseInt(x)
                    + Integer.parseInt(y) == Integer.parseInt(suffix)) {
                    result = true;
                    return result && isSumString(prefix.substring(0, i), prefix.substring(i + 1, prefix.length()));

                }
            }
        }
        return result;
    }
}
