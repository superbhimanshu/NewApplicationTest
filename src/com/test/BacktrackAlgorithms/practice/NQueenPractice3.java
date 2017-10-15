package com.test.BacktrackAlgorithms.practice;

import java.util.Scanner;

/**
 * Created by hverma on 6/6/17.
 */
public class NQueenPractice3 {

    public static int M =6;

    public static void main(String[] args){

        System.out.println("enter n for nxn ");
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();

        int[][] chess = new int[M][M];
        for (int i=0;i<M;i++){
            for (int j=0;j<M;j++){
                chess[i][j] =0;
            }
        }
        solveQueenProb(chess, 0);
        printArray(chess);
    }

    public static boolean solveQueenProb(int[][] chess, int colNum){

        if(colNum == M){
            return true;
        }

        for (int i=0; i<M;i++){
            if(isItSafe(chess,colNum,i)){
                chess[i][colNum]=1;
            }else{
                continue;
            }

            if(solveQueenProb(chess,colNum+1)){
                return true;
            }else{
                chess[i][colNum]=0;
            }
        }

        return false;

    }

    public static boolean isItSafe(int[][] chess, int colNum, int rowNum){
        //check left upper side diagonals
        for(int j=colNum-1,i=rowNum-1;j>=0 && i>=0;j--,i--){
            if(chess[i][j]==1){
                return false;
            }
        }
        //check lower side diag
        for(int j=colNum-1,i=rowNum+1;j>=0 && i<M;j--,i++){
            if(chess[i][j]==1){
                return false;
            }
        }

        //check left row
        for(int j=colNum-1;j>=0;j--){
            if(chess[rowNum][j]==1){
                return false;
            }
        }

        return true;
    }

    public static void printArray(int[][] chess) {
        for(int i=0;i<M;i++){
            for(int j=0;j<M;j++){
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }
    }

}
