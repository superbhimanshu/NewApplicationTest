package com.geeksforgeeks.Easy;

import java.util.Stack;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by hverma on 11/7/17.
 * http://practice.geeksforgeeks.org/problems/decode-the-string/0
 */
public class DecodeString {

    public static void main(String[] args){

        String encoded = "3[a3[b]1[ab]]";

        String e1 = "3[b2[ca]]";
        String e2 = "1[b]";
        String decoded = decodeString( encoded);
        System.out.println(decoded);
        System.out.println(decodeString( e1));
        System.out.println(decodeString( e2));

    }

    public static String decodeString(String encoded){

        Stack<Character> s = new Stack<>();
        String decoded = "";

        for (Character c : encoded.toCharArray()){
            if(c != ']'){
                s.add(c);
            } else {
                String temp ="";
                while( s.peek() != '[' ){
                    temp = s. pop() + temp;
                }
                s.pop();
                int freq = Integer.parseInt(String.valueOf(s.pop()));
                String str = "";
                for(int i=0; i< freq;i++){
                    str = str + temp;
                }
                for(int i=0; i<str.length();i++){
                    s.push(str.charAt(i));
                }
            }
        }

        while(CollectionUtils.isNotEmpty(s)){
            decoded = s.pop() + decoded;
        }

        return decoded;
    }


}
