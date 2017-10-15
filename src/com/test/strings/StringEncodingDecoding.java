package com.test.strings;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * Created by hverma on 6/6/17.
 */
public class StringEncodingDecoding {

    public static void main(String[] args){
        String s = "aaaabbcd";
        //expected output = a3b2cd
        String enc = "a3b2sdc";

        String encoded = encode(s);
        System.out.println(encoded);
        System.out.println(decodeLinkedList(enc));
    }

    public static String encode(String s){
        if(s.length()<2){
            return s;
        }
        if(s.length()==2){
            if(s.charAt(0)==s.charAt(1)){
                return s.charAt(0)+"2";
            }else{
                return s;
            }
        }

        for(int i=0;i<s.length();i++){
            int c = i+1;
            while(c<s.length() && s.charAt(c)==s.charAt(i)){
                c++;
            }
            if(c-i!=1){
                s = s.substring(0,i+1) + (c-i) + s.substring(c);
                i++;
            }
        }
        return s;
    }

    public static String cstr(String a){
        if(a.length()<2){return a;}
        if(a.length()==2){if(a.charAt(0)==a.charAt(1)){return a.charAt(0)+"2";}else{return a;}}
        for(int i=0;i<a.length();i++){
            int c=i+1;
            while(c<a.length()&&a.charAt(c)==a.charAt(i)){
                c++;
            }
            if(c-i!=1){
                a=a.substring(0,i+1)+(c-i)+a.substring(c);i++;
            }

        }
        return a;
    }
//use linkedhashmap while decoding
    public static String decode(String s){
        if(s.length()<2){
            return s;
        }
        if(s.length()==2 && (int)s.charAt(1)>=48 && (int)s.charAt(1)<=57){
            String ret = "";
            for(int i=0; i< Integer.valueOf(s.substring(1));i++){
                ret = ret + s.charAt(0);
            }
            return ret;
        }else if(s.length()==2){
            return s;
        }
        for(int i=0;i<s.length();i++){
            int c =i+1;
            String r = "";
            while(c < s.length() && (int)s.charAt(c)>=48 && (int)s.charAt(c)<=57){

                r = r + s.charAt(c);
                c++;
            }
            String str = "";

            for(int j=0;r.length()>0 && j<Integer.parseInt(r); j++){
                str = str + s.charAt(i);
            }
            i=i+c;
            s = str + s.substring(c);
        }


        return s;
    }

    public static String decodeLinkedList(String s){
        LinkedList<Node> m = new LinkedList<>();


        if(s.length()<2){
            return s;
        }
        if(s.length()==2 && (int)s.charAt(1)>=48 && (int)s.charAt(1)<=57){
            String ret = "";
            for(int i=0; i< Integer.valueOf(s.substring(1));i++){
                ret = ret + s.charAt(0);
            }
            return ret;
        }else if(s.length()==2){
            return s;
        }

        String lastChar="";
        for(int i=0;i<s.length();i++) {

            if(i==s.length()-1){
                lastChar = String.valueOf(s.charAt(i));
            }
            int c = i + 1;
            String r = "";
            while (c < s.length() && (int) s.charAt(c) >= 48 && (int) s.charAt(c) <= 57) {

                r = r + s.charAt(c);
                c++;
            }
            if(r.length()!=0){
                Node n = new Node();
                n.count = Integer.parseInt(r);
                n.s = String.valueOf(s.charAt(i));
                m.add(n);
                i=c-1;
            }
        }

        Iterator<Node> it = m.iterator();
        String str="";
        while(it.hasNext()){
            Node n = it.next();
            for(int i=0;i<n.count;i++){
                str = str + n.s;
            }
        }

        return str + lastChar;

    }

    static class Node {
        String s;
        int count;
    }

}
