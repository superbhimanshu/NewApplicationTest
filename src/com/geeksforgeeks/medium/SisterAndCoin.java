package com.geeksforgeeks.medium;

import javax.swing.plaf.synth.SynthTextAreaUI;

/**
 * Created by hverma on 12/5/17.
 */
public class SisterAndCoin {

    public static void main(String[] args){

        int[] coins = {1,2,3,0,6};
        int[] coins2 = {1,2,3,2,6};

        System.out.print(isMatch(12, coins, 6, 4));
        System.out.print(isMatch(14, coins, 6, 4));
        System.out.print(isMatch(14, coins2, 5, 4));
    }

    public static boolean isMatch(int sum1, int[] coins, int sum2, int index){
        if(sum1 == sum2){
            return true;
        }else if(sum2 > sum1){
            return false;
        }else{
            for(int i=index; i>=0;i--){
                return isMatch(sum1 - coins[i], coins, sum2 + coins[i], i - 1) || isMatch(sum1, coins, sum2, i -1);
            }
        }
        return false;
    }

}
