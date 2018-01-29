package com.geeksforgeeks.Easy;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by hverma on 11/12/17.
 * Given a string you need to print all possible strings that can be made by placing spaces (zero or one) in between them. Output should be printed in sorted increasing order of strings.

 Input:  str[] = "ABC"
 Output: (A B C)(A BC)(AB C)(ABC)
 */
public class PermutationWithSpaces {

    public static void main(String[] args){
        String s = "ABC";
        printComboWithSpace(s.substring(0,1), s.substring(1,s.length()));

      //  printComboWithSpace("A", "B");
    }
    public static void printComboWithSpace(String prefix, String s){

        if(StringUtils.isBlank(s)){
            System.out.println(prefix);
            return;
        }

        if(prefix.substring(prefix.length()-1, prefix.length()).equals(" ")){
            printComboWithSpace(prefix + s.substring(0,1), s.substring(1,s.length()));
        }else {
            printComboWithSpace(prefix + " ", s);
            printComboWithSpace(prefix + s.substring(0,1), s.substring(1,s.length()));
        }

    }

}
