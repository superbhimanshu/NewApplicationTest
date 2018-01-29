package com.test.recursion;

/**
 * Created by hverma on 11/4/17.
 */
public class CoinChangePrintAllCombo {

    static int N = 26;

//    static int[] denominations = { 25, 10, 5, 2 };
    static int[] denominations = { 2,5,10,25};


    public static void main(String[] args) {

        printAllCombo(denominations, new int[denominations.length], 0, N);
   //     System.out.println(count(denominations, denominations.length, N));
        System.out.println(minimumNumberOfCoinsNeeded(denominations,N));
    }

    private static void printAllCombo(int[] denominations, int[] numberOfCoins, int index, int remainingValue) {

        if (index == numberOfCoins.length - 1) {
            if (remainingValue % denominations[index] == 0) {
                numberOfCoins[index] = remainingValue / denominations[index];
                for (int i = 0; i < numberOfCoins.length; i++) {
                    System.out.print("" + numberOfCoins[i] + " ");
                }
                System.out.println();
            }
            return;
        } else {
            for (int i = 0; i <= remainingValue / denominations[index]; i++) {

                numberOfCoins[index] = i;
                printAllCombo(denominations, numberOfCoins, index + 1, remainingValue - denominations[index] * i);
            }
        }
    }

    // Returns the count of ways we can sum  S[0...m-1] coins to get sum n
    public static int count(int S[], int m, int n) {
        // If n is 0 then there is 1 solution (do not include any coin)
        if (n == 0)
            return 1;

        // If n is less than 0 then no solution exists
        if (n < 0)
            return 0;

        // If there are no coins and n is greater than 0, then no solution exist
        if (m <= 0 && n >= 1)
            return 0;

        // count is sum of solutions (i) including S[m-1] (ii) excluding S[m-1]
        return count(S, m - 1, n) + count(S, m, n - S[m - 1]);
    }



    public static int minimumNumberOfCoinsNeeded(int[] denominations, int remainingSum) {

        if(remainingSum == 0) {
            return 0;
        }
        //result initialize
        int res = Integer.MAX_VALUE;

        //try for every coin which has value less than V
        for(int i=0;i<denominations.length; i++){
            if(denominations[i] <= remainingSum){
                int sub_res = minimumNumberOfCoinsNeeded(denominations,remainingSum - denominations[i]);
                // Check for INT_MAX to avoid overflow and see if
                // result can minimized
                if (sub_res != Integer.MAX_VALUE && sub_res + 1 < res)
                    res = sub_res + 1;
            }
        }
        return res;

    }

}
