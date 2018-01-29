package com.geeksforgeeks.Basic;

/**
 * Created by hverma on 11/6/17.
 */
public class CountAllPossiblePaths {

    public static void main(String[] args){
        int M= 3, N=3;
        System.out.print(countPath(1,1,M,N));
    }

    public static int countPath(int row, int col, int M, int N){
        if(row == M && col ==N){
            return 1;
        }
        if(row>M || col>N){
            return 0;
        }

        return countPath(row+1, col,M,N) + countPath(row,col+1,M,N);
    }
}
