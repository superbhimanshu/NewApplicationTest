package com.geeksforgeeks.Easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hverma on 11/7/17.
 * http://practice.geeksforgeeks.org/problems/recamans-sequence/0
 */
public class RecamanSequence {

    public static void main(String[] args){
        int N = 6;
        List<Integer> l = new ArrayList<>();
        recmanSeries(new int[N],0,N);
//        fillRecamanSeq(N,l);
//        System.out.println(l.toString());
    }
    public static int fillRecamanSeq(int N, List<Integer> l){
        if(N < 0){
            return 0;
        }
        if(N==0) {
            l.add(0);
//            return 0;
        }
        int newNum = fillRecamanSeq(N-1,l);
        int res = newNum;
        if(N>0){
            if(!l.contains(N)) {
                res = newNum - N;
            }else{
                res = newNum + N;
            }
            l.add(res);
        }


        return  res;
    }

    public static int recmanSeries(int arr[],int s,int n)
    {
        if(s==0){
            return 0;
        }
        if(s == n+1)
            return arr[n];
        boolean isPresent = false;
        for(int i=0;i < s;i++)
        {
            if(arr[i] == (arr[s-1]-s) || (arr[s-1]-s) <= 0)
            {
                isPresent = true;
            }
        }
        if(isPresent)
            arr[s] = arr[s-1]+s;
        else
            arr[s] = arr[s-1]-s;
        System.out.print(arr[s]+ " ");
        return recmanSeries(arr,s+1,n);
    }
}
