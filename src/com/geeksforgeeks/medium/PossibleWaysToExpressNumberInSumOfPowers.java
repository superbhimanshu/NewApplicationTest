package com.geeksforgeeks.medium;

/**
 * Created by hverma on 12/6/17.
 *
 * Input  : X = 10, N = 2
 Output : 1
 Explanation: 10 = 1^2 + 3^2, // 1 + 9
 Hence total 1 possibility

 Input  : X = 100, N = 2
 Output : 3
 Explanation: 100 = 10^2
 OR 6^2 + 8^2
 OR 1^2 + 3^2 + 4^2 + 5^2 + 72
 Hence total 3 possibilities

 */
public class PossibleWaysToExpressNumberInSumOfPowers {

    public static void main(String[] args){
        double x = 100;
        double n= 2;

        System.out.println(Math.pow(x,1/n));
        for(int i=1;i<=Math.pow(x, 1/n);i++) {
            System.out.println(sumOfPower(i, x - Math.pow(i,n), n, x));
        }
    }

    public static int sumOfPower(int num, double remaining, double n, double x){
        if(remaining==0){
            return 1;
        }else if(remaining <0){
            return 0;
        }else {
            for(int j= num; j<=Math.pow(x, 1/n); j++){
                return sumOfPower(j+1, remaining - Math.pow(j+1, n), n, x) + sumOfPower(j+1, remaining, n, x);
            }
        }
        return 0;
    }

}
