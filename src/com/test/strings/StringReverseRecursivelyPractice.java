package com.test.strings;

/**
 * Created by hverma on 6/6/17.
 */
public class StringReverseRecursivelyPractice {

    public static void main(String[] args) {
        String s = "abcde";
        String a = reverse(s);
        System.out.println(a);
    }

    public static String reverse(String s){
        if(s==null || s.length()==0)
            return "";
        else
            return reverse(s.substring(1,s.length())) + s.charAt(0);
    }
}
