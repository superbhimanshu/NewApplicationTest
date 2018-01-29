package com.geeksforgeeks.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by hverma on 11/5/17.
 * //problem description http://practice.geeksforgeeks.org/problems/print-n-bit-binary-numbers-having-more-1s-than-0s/0
 */
public class PrintNBitBinaryNumber {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<String> out = printAllBits(N);

        for (String s : out){
            System.out.print(s + " ");
        }

    }

    //algo  print(n) = checkSuccess(print(n-1) + 1) + checkSuccess(print(n-1) + 0)

    public static List<String> printAllBits(int n){

        List<String> out = new ArrayList<String>();

        if(n<=0){
            return  out;
        }

        if(n == 1){
            out.add("1");
            return out;
        }
        for(int i=0; i<printAllBits(n-1).size(); i++){
            String toBeAdded1  = printAllBits(n-1).get(i) + "1";
            String toBeAdded0 = printAllBits(n-1).get(i) + "0";


            if(isConditionMet(toBeAdded1)){
                out.add(toBeAdded1);
            }
            if(isConditionMet(toBeAdded0)){
                out.add(toBeAdded0);
            }
        }

        return out;
    }

    public static boolean isConditionMet(String str){

        int count1=0;
        int count0=0;
        for(int i=0; i<str.length();i++){
            if(str.charAt(i) == '1'){
                count1++;
            } else if(str.charAt(i) == '0'){
                count0++;
            }
        }

        return count1 > count0;
    }
}
