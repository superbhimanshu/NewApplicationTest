package com.geeksforgeeks.Easy;

/**
 * Created by hverma on 11/12/17.
 */
public class FIndProfession {

    public static void main(String[] args){

        int level = 4;
        int leafNumber = 2;

        System.out.println(findProfession(level, leafNumber));
    }

    public static Character findProfession(int level, int pos){
        if(level == 1){
            return 'E';
        }

        if(findProfession(level-1,(pos+1)/2) == 'D'){
            return (pos%2 == 1) ? 'D' : 'E';
        }

        return (pos%2 ==1) ? 'E':'D';
    }

}
