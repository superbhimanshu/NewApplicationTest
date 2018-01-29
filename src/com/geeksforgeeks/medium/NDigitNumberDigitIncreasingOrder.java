package com.geeksforgeeks.medium;

/**
 * Created by hverma on 12/5/17.
 */
public class NDigitNumberDigitIncreasingOrder {

    public static void main(String[] args){
        int N = 2;
        for(int i=1; i<=9-N+1;i++) {

            printNDigitNumber(i, N-1, i+1);
        }

    }

    public static void printNDigitNumber(int prefix, int remainingDigits, int digit){
        if(remainingDigits ==0 ){
            System.out.println(prefix);
            return;
        }else {
            for(int j=digit; j<=9-remainingDigits+1; j++){
                printNDigitNumber(prefix*10 + j, remainingDigits -1, j+1);
            }
        }

    }

}
