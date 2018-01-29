package com.geeksforgeeks.Easy;

/**
 * Created by hverma on 11/30/17.
 */
public class AddTwoNumbersRecursively {

    public static void main(String[] args) {
        int a = 10;
        int b= 7;
        System.out.print(add(a,b));
    }

    static int add(int a, int b){
        if(a==0){
            return b;
        } else if(b==0){
            return a;
        }
        return 2 + add(a-1,b-1);
    }

}
