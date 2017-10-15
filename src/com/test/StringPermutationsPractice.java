package com.test;

/**
 * Created by hverma on 6/6/17.
 */
public class StringPermutationsPractice {

    public static void main(String[] args) {

        String a = "abc";
        //print abc, acb,bca,bac,cab,cba
        //List<String> p = permutation(a);

        permutation(a);
        //	System.out.println(st);


    }

    public static void permutation(String a){
        permutation("",a);
    }

    public static void permutation(String prefix, String a){
        int n = a.length();
        if(n==0){
            System.out.println(prefix);
        }else {
            for(int i=0;i<n;i++){
                permutation(prefix + a.charAt(i), a.substring(0, i) + a.substring(i+1, n));
            }
        }
    }

}
