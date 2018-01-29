package com.geeksforgeeks.Easy;

/**
 * Created by hverma on 11/7/17.
 * http://practice.geeksforgeeks.org/problems/recursive-sequence/0
 */
public class RecursiveSequence {

    public static void main(String[] args){
        int N = 5;
        System.out.print(func(N));
    }

    public static int func(int N){
        if(N==1){
            return 1;
        }

        int startTerm = findStart(N);
        int t=1;
        for (int i=0;i<N;i++){
            t = t*(startTerm + i);
        }
        return func(N-1) + t;
    }

    public static int findStart(int N){
        if(N==1 || N==2){
            return N;
        }
        return N-1 + findStart(N-1);
    }
}
