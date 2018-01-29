package com.geeksforgeeks.Basic;

/**
 * Created by hverma on 11/7/17.
 */
public class PrintAllPermutations {

    public static void main(String[] args){
        String s = "ABC";
        printAllCombos("ABC", "");
    }

    public static void printAllCombos(String s, String prefix){

       int n = s.length();
        if(n==0){
            System.out.println(prefix);
            return;
        } else {
            for (int i=0; i<n;i++){
                printAllCombos(s.substring(0,i) + s.substring(i+1,n), prefix + s.charAt(i));
            }
        }


    }

}
