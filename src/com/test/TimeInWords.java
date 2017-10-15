package com.test;

import java.util.HashMap;
import java.util.Scanner;

public class TimeInWords {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<Integer, String> intToWord = new HashMap<Integer,String>();
        String quarter="quarter", past="past",to="to", minute="minute", minutes="minutes", oclock="o' clock";
        String half = "half";
        fillHashMap(intToWord);
        int h = in.nextInt();
        int m = in.nextInt();
        if(m==0){
            System.out.println(intToWord.get(h)+ " " + oclock);
            return;
        }
        if(m==45){
            if(h==12){
                System.out.println(quarter + " " + to + " " + "one");
                return;
            }else {
                System.out.println(quarter + " " + to + " " + intToWord.get(h+1));
                return;
            }
        }
        if(m==15){
                System.out.println(quarter + " " + past + " " + intToWord.get(h));
                return;        
        }
        if(m==30){
            System.out.println(half + " " + past + " " + intToWord.get(h));
            return;
        }
        if(m < 30){
            if(m==1){
                System.out.println("one minute past " + intToWord.get(h));
                return;
            }
            String word = intToWord.get(m);
            if(word!=null){
                System.out.println(word + " " + minutes + " " + past + " " + intToWord.get(h));
                return;
            }else {
                word = findBucket(m,intToWord);
                System.out.println(word + " " +minutes + " " + past + " " + intToWord.get(h));
                return;
            }
            
        }
        if(m>30){
            int diff = 60 - m;
             if(diff==1){
                System.out.println("one minute " + to + " "+ intToWord.get(h+1));
                return;
            }
            String word = intToWord.get(diff);
            if(word!=null){
                if(h==12){
                    System.out.println(word + " " + minutes + " " + to + " " + intToWord.get(1));
                    return;                    
                }else {
                    System.out.println(word + " " + minutes + " " + to + " " + intToWord.get(h+1));
                    return;
                }
            }else {
                word = findBucket(diff,intToWord);
                if(h==12){
                    System.out.println(word + " " + minutes + " " + to + " " + intToWord.get(1));
                    return;                    
                }else {
                    System.out.println(word + " " + minutes + " " + to + " " + intToWord.get(h+1));
                    return;
                }
            }
                       
        }
    }
    
    public static void fillHashMap(HashMap<Integer, String> intToWord){
        intToWord.put(1,"one");
        intToWord.put(2,"two");
        intToWord.put(3,"three");
        intToWord.put(4,"four");
        intToWord.put(5,"five");
        intToWord.put(6,"six");
        intToWord.put(7,"seven");
        intToWord.put(8,"eight");
        intToWord.put(9,"nine");
        intToWord.put(10,"ten");
        intToWord.put(11,"eleven");
        intToWord.put(12,"twelve");
        intToWord.put(13,"thirteen");
        intToWord.put(14,"fourteen");
        intToWord.put(15,"fifteen");
        intToWord.put(16,"sixteen");
        intToWord.put(17,"seventeen");
        intToWord.put(18,"eighteen");
        intToWord.put(19,"nineteen");
        intToWord.put(20,"twenty");
        intToWord.put(30,"thirty");
        intToWord.put(40,"forty");
        intToWord.put(50,"fifty");
       
    }
    
    public static String findBucket(int n, HashMap<Integer,String> intToWord){
        String val = null;
        int i=0;
        if(n<30){
            i=n-20;
            val = "twenty " + intToWord.get(i);
            return val;
        }else if(n<40){
            i=n-30;
            val = "thirty " + intToWord.get(i);
            return val;
        }else if(n<50){
            i=n-40;
            val = "forty " + intToWord.get(i);
            return val;
        }else if(n<60){
            i=n-50;
            val = "fifty " + intToWord.get(i);
            return val;
        }
        return null;
    }
}
