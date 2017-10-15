package com.test.intTests;

import java.util.Scanner;

public class LongSummation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        System.out.println("enter data: \n ");
        String inVals = in.nextLine();
        String[] intStrs = inVals.split(" ");
        Long summation = 0L;        
 //       int arr[] = new int[n];
        for(int i=0; i < n; i++){
 //           try{
                summation = summation + Long.parseLong(intStrs[i]);
//            }catch(Exception e){
//                return;
//            }
        }
        System.out.println(summation);
    }
}
