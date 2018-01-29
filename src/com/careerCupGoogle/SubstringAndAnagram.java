package com.careerCupGoogle;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by hverma on 10/14/17.
 *
 * Given 2 words, return true if second word has a substring that is also an anagram of word 1.
 LGE , GOOGLE- True
 GEO, GOOGLE - False
 */
public class SubstringAndAnagram {

    static Set<String> allPermutFirstWord = new HashSet<>();
    public static void main(String[] args){
        String firstWord = "GEO";
        String secondWord = "GOOGLE";

        System.out.println(subStringAnagram(firstWord, secondWord));
    }

    private static boolean subStringAnagram(String firstWord, String secondWord){

        boolean result = false;

        allPermutation("", firstWord);
        for(String s : allPermutFirstWord){
            if(secondWord.contains(s)){
                result = true;
            }
        }

        return result;
    }

    private static void allPermutation(String prefix, String str){

        int n = str.length();
        if(n==0){
            allPermutFirstWord.add(prefix);
            System.out.println(prefix);
        }else {
            for(int i=0;i<str.length();i++){
                allPermutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
            }
        }

    }

}
