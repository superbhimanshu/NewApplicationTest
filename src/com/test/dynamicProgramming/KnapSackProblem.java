package com.test.dynamicProgramming;

/**
 * Created by hverma on 11/4/17.
 */
public class KnapSackProblem {
    static int capacity = 10;
    static int numberOfItems = 5;
    static int[] weightOfItems = {1,2,3,4,5}; //in kgs
    static int[] valuesOfItems = {5,3,5,3,2}; //values

    public static void main(String[] args) {

        //find list of items to add to a bag which has capacity of 10kg that maximizes the sum of value.
        System.out.println(knapsack(5,10));
    }

    public static int knapsack(int n, int leftCapacity){
        if(n==0 || leftCapacity==0){
            return 0;
        }
        int temp1 = knapsack(n-1,leftCapacity);
        int temp2 = knapsack(n-1, leftCapacity - weightOfItems[n-1]) + valuesOfItems[n-1];
        return Math.max(temp1,temp2);
    }

}
