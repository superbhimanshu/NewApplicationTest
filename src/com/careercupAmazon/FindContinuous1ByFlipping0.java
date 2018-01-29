package com.careercupAmazon;

/**
 * Created by hverma on 12/12/17.
 *
 * You are given with an array of 1s and 0s. And you are given with an integer m, which signifies number of flips allowed.

 find the position of zeros which when flipped will produce maximum continuous series of 1s.

 e.g.
 input:
 arr={1 1 0 1 1 0 0 1 1 1 } m=1
 output={1 1 1 1 1 0 0 1 1 1} position=2

 arr={1 1 0 1 1 0 0 1 1 1 } m=2
 output={1 1 0 1 1 1 1 1 1 1} position=5,6


 */
public class FindContinuous1ByFlipping0 {

    public static void main(String[] args){
        int[] arr = {1,1,0,1,1,0,0,1,1,1};
        int m = 2;
        int wL = 0, wR=0;
        int bestWindowLenth = -1;
        int numberOfZeros = 0;
        int bestWL = -1;
        int bestWR = -1;
        while(wR < arr.length-1){

            if(numberOfZeros <= m){
                wR++;
                if(arr[wR] == 0){
                    numberOfZeros++;
                }
            }

            if(numberOfZeros > m ){
                wL++;
                if(arr[wL] == 0){
                    numberOfZeros--;
                }
            }

            if(wR - wL > bestWindowLenth){
                bestWindowLenth = wR -wL;
                bestWL = wL;
                bestWR = wR;
            }
        }

        System.out.println("flipZero between " + bestWL + "and " + bestWR );
    }

}
