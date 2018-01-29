package com.geeksforgeeks.Basic;

/**
 * Created by hverma on 11/6/17.
 * http://practice.geeksforgeeks.org/problems/subset-sums/0
 */
public class SubsetSums {

    public static void main(String[] args){
        int[] a = {0, 2,3};

        subsetSum(0, a, 0);

    }



    private static void subsetSum(int index, int[] a, int sum){
        if(index == a.length){
            System.out.println(sum);
            return;
        }

      //  for(int i=index; i<a.length; i++){
      //      subsetSum(i+1, a, sum + a[i]);
        //    subsetSum(i+1,a,sum);
        //}

              subsetSum(index+1, a, sum + a[index]);
            subsetSum(index+1,a,sum);
    }



    public static void printSubsetSum(int[] a, int start, int end){

        if(start >= end ){
            System.out.print(a[start-1] + " ");
        }


        for (int i=start+1; i<end; i++){
            int sum =0;
       //     for(int j=)
        }

    }

}
