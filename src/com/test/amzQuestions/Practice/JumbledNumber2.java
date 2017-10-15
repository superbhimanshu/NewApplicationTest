package com.test.amzQuestions.Practice;

import java.util.*;

import javax.sound.midi.SysexMessage;

/**
 * Created by hverma on 6/6/17.


//Write all jumbled number which is >0 && <N, where N is provided by the user.
//A jumbled number is a number whose neighbour digit (either left or right) max differ by 1 value.
//
//e.g.:
//8987 is a jumbled number.
//13 is not a jumbled number.
//123456 is a jumbled number.
//287 is not jumbled number.
 */

public class JumbledNumber2 {

    public static void main (String[] args){
        System.out.println("enter N : ");
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        if(N < 10){
            System.out.print("enter 10 or more");
            System.exit(1);
        }
        for (int i=10;i<=N;i++){
            if(isJumbled(i)){
                System.out.println(i);
            }
        }

    }

    public static boolean isJumbled(int i){
        int j= i%10;
        i = i/10;

        while(i!=0){
            int k = i%10;
            if(Math.abs(k -j)!=1){
                return false;
            }
            j=k;
            i=i/10;
        }
        return true;

    }
}
