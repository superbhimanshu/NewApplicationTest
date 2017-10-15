package com.test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by hverma on 6/6/17.
 */
public class StringSubstringSetPractice {

    public static void main(String[] args){
        String str = "abcda";
        Set<String> s = new HashSet<>();

        for(int i=0;i<str.length();i++){
            for(int j=i+1;j<str.length();j++){
                s.add(str.substring(i,j));
            }

        }
        System.out.println(s.toString() + " size " + s.size());
    }

}
